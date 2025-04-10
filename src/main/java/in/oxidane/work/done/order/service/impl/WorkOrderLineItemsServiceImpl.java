package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.order.dao.WorkOrderLineItemsDao;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsRequest;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsResponse;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import in.oxidane.work.done.order.mapper.WorkOrderLineItemsMapper;
import in.oxidane.work.done.order.service.WorkOrderLineItemsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkOrderLineItemsServiceImpl implements WorkOrderLineItemsService {

    private final WorkOrderLineItemsDao workOrderLineItemsDao;
    private final WorkOrderLineItemsMapper workOrderLineItemsMapper;

    @Override
    public WorkOrderLineItemsResponse create(WorkOrderLineItemsRequest request) {
        log.info("Creating new work order line item");
        WorkOrderLineItems lineItem = workOrderLineItemsMapper.toEntity(request);
        WorkOrderLineItems savedLineItem = workOrderLineItemsDao.save(lineItem);
        log.info("Created work order line item with ID: {}", savedLineItem.getWoLineItemId());
        return workOrderLineItemsMapper.toResponse(savedLineItem);
    }

    @Override
    public WorkOrderLineItemsResponse update(Long id, WorkOrderLineItemsRequest request) {
        log.info("Updating work order line item with ID: {}", id);
        WorkOrderLineItems existingLineItem = workOrderLineItemsDao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Work order line item not found with ID: " + id));

        WorkOrderLineItems updatedLineItem = workOrderLineItemsMapper.toUpdateEntityFromRequest(request, existingLineItem);
        WorkOrderLineItems savedLineItem = workOrderLineItemsDao.save(updatedLineItem);
        log.info("Updated work order line item with ID: {}", id);
        return workOrderLineItemsMapper.toResponse(savedLineItem);
    }

    @Override
    public WorkOrderLineItemsResponse getById(Long id) {
        log.info("Fetching work order line item by ID: {}", id);
        return workOrderLineItemsDao.findById(id)
            .map(workOrderLineItemsMapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Work order line item not found with ID: " + id));
    }

    @Override
    public List<WorkOrderLineItemsResponse> getAll() {
        log.info("Fetching all work order line items");
        return workOrderLineItemsMapper.toResponse(workOrderLineItemsDao.findAll());
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting work order line item with ID: {}", id);
        if (!workOrderLineItemsDao.existsById(id)) {
            throw new EntityNotFoundException("Work order line item not found with ID: " + id);
        }
        workOrderLineItemsDao.deleteById(id);
        log.info("Deleted work order line item with ID: {}", id);
    }
}
