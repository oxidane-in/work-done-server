package in.oxidane.work.done.lineitem.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.common.exception.ValidationException;
import in.oxidane.work.done.lineitem.dao.LineItemDao;
import in.oxidane.work.done.order.dao.UnitOfMeasurementDao;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import in.oxidane.work.done.lineitem.mapper.LineItemMapper;
import in.oxidane.work.done.lineitem.service.LineItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the LineItemService interface.
 * Provides business operations for LineItem entities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LineItemServiceImpl implements LineItemService {

    private final LineItemDao lineItemDao;
    private final UnitOfMeasurementDao unitOfMeasurementDao;
    private final LineItemMapper lineItemMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public LineItemResponse createLineItem(LineItemRequest request) {
        log.info("Creating new line item");
        log.debug("Line item request: {}", request);

        validateRequest(request, null);

        // Get UnitOfMeasurement entity
        UnitOfMeasurement unitOfMeasurement = getUnitOfMeasurementById(request.getUnitOfMeasurementId());

        // Map request to entity
        LineItem lineItem = lineItemMapper.toEntity(request)
            .toBuilder()
            .unitOfMeasurement(unitOfMeasurement)
            .build();

        // Create and return response
        LineItem savedLineItem = lineItemDao.create(lineItem);
        log.info("Successfully created line item with id: {}", savedLineItem.getLineItemId());

        return lineItemMapper.toResponse(savedLineItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LineItemResponse getLineItemById(Long id) {
        log.info("Fetching line item with id: {}", id);

        LineItem lineItem = lineItemDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Line item not found with id: {}", id);
                return new ResourceNotFoundException("Line item not found with id: " + id);
            });

        log.debug("Retrieved line item: {}", lineItem);
        return lineItemMapper.toResponse(lineItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LineItemResponse> getAllLineItems() {
        log.info("Fetching all line items");

        List<LineItem> lineItems = lineItemDao.getAll();
        log.debug("Retrieved {} line items", lineItems.size());

        return lineItemMapper.toResponse(lineItems);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LineItemResponse updateLineItem(Long id, LineItemRequest request) {
        log.info("Updating line item with id: {}", id);
        log.debug("Update request: {}", request);

        validateRequest(request, id);

        // Ensure line item exists
        LineItem existingLineItem = lineItemDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Line item not found with id: {}", id);
                return new ResourceNotFoundException("Line item not found with id: " + id);
            });

        // Get UnitOfMeasurement entity
        UnitOfMeasurement unitOfMeasurement = getUnitOfMeasurementById(request.getUnitOfMeasurementId());

        // Map request to entity
        LineItem lineItem = lineItemMapper.toUpdateEntityFromRequest(request, existingLineItem)
            .toBuilder()
            .unitOfMeasurement(unitOfMeasurement)
            .build();

        // Update and return response
        LineItem updatedLineItem = lineItemDao.update(lineItem);
        log.info("Successfully updated line item with id: {}", id);

        return lineItemMapper.toResponse(updatedLineItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteLineItem(Long id) {
        log.info("Deleting line item with id: {}", id);

        // Check if the resource exists first
        if (!lineItemDao.existsById(id)) {
            log.warn("Cannot delete - line item not found with id: {}", id);
            throw new ResourceNotFoundException("Line item not found with id: " + id);
        }

        lineItemDao.delete(id);
        log.info("Successfully deleted line item with id: {}", id);
    }

    /**
     * Validates a line item request.
     *
     * @param request The request to validate
     * @param id      The ID of the line item being updated, or null for creation
     */
    private void validateRequest(LineItemRequest request, Long id) {
        if (request == null) {
            throw new ValidationException("Line item request cannot be null");
        }

        // Check if unit of measurement exists
        if (request.getUnitOfMeasurementId() == null) {
            throw new ValidationException("Unit of measurement ID is required");
        }

        if (id != null) {
            // When updating, check if handle exists for another line item
            if (request.getLineItemHandle() != null &&
                lineItemDao.existsByHandleAndIdNot(request.getLineItemHandle(), id)) {
                throw new ValidationException("Line item with handle '" + request.getLineItemHandle() + "' already exists");
            }
        } else {
            // When creating, check if handle exists
            if (request.getLineItemHandle() != null &&
                lineItemDao.existsByHandle(request.getLineItemHandle())) {
                throw new ValidationException("Line item with handle '" + request.getLineItemHandle() + "' already exists");
            }
        }
    }

    /**
     * Retrieves a unit of measurement by ID and throws an exception if not found.
     *
     * @param id The ID of the unit of measurement to retrieve
     * @return The unit of measurement
     * @throws ResourceNotFoundException if the unit of measurement is not found
     */
    private UnitOfMeasurement getUnitOfMeasurementById(Long id) {
        return unitOfMeasurementDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Unit of measurement not found with id: {}", id);
                return new ResourceNotFoundException("Unit of measurement not found with id: " + id);
            });
    }
}
