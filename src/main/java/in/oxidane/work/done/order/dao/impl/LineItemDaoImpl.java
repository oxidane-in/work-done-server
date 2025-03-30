package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.LineItemDao;
import in.oxidane.work.done.order.entity.LineItem;
import in.oxidane.work.done.order.repository.LineItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the LineItemDao interface.
 * Provides data access operations for LineItem entities.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LineItemDaoImpl implements LineItemDao {

    private final LineItemRepository lineItemRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<LineItem> getById(Integer id) {
        log.debug("Fetching line item with id: {}", id);
        return lineItemRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LineItem> getAll() {
        log.debug("Fetching all line items");
        return lineItemRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LineItem create(LineItem lineItem) {
        log.debug("Creating line item: {}", lineItem);
        return lineItemRepository.save(lineItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LineItem update(LineItem lineItem) {
        log.debug("Updating line item with id: {}", lineItem.getLineItemId());
        return lineItemRepository.save(lineItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        log.debug("Deleting line item with id: {}", id);
        lineItemRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Integer id) {
        log.debug("Checking if line item exists with id: {}", id);
        return lineItemRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandle(String handle) {
        log.debug("Checking if line item exists with handle: {}", handle);
        return lineItemRepository.existsByLineItemHandle(handle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandleAndIdNot(String handle, Integer id) {
        log.debug("Checking if line item exists with handle: {} excluding id: {}", handle, id);
        return lineItemRepository.existsByLineItemHandleAndLineItemIdNot(handle, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LineItem> getByUnitOfMeasurementId(Integer uomId) {
        log.debug("Fetching line items by unit of measurement id: {}", uomId);
        return lineItemRepository.findByUnitOfMeasurement_UomId(uomId);
    }
} 