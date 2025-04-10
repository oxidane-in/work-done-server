package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.WorkOrderDao;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.order.mapper.WorkOrderMapper;
import in.oxidane.work.done.order.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderDao workOrderDao;
    private final WorkOrderMapper workOrderMapper;

    @Override
    public WorkOrderResponse create(WorkOrderRequest request) {
        log.info("Creating new work order with code: {}", request.getWorkOrderCode());

        if (workOrderDao.existsByCode(request.getWorkOrderCode())) {
            throw new IllegalArgumentException("Work order with code " + request.getWorkOrderCode() + " already exists");
        }

        WorkOrder workOrder = workOrderMapper.toEntity(request);
        WorkOrder savedWorkOrder = workOrderDao.save(workOrder);

        log.info("Successfully created work order with ID: {}", savedWorkOrder.getWorkOrderId());
        return workOrderMapper.toResponse(savedWorkOrder);
    }

    @Override
    public WorkOrderResponse update(Long id, WorkOrderRequest request) {
        log.info("Updating work order with ID: {}", id);

        WorkOrder existingWorkOrder = workOrderDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Work order not found with ID: " + id));

        WorkOrder updatedWorkOrder = workOrderMapper.toUpdateEntityFromRequest(request, existingWorkOrder);
        WorkOrder savedWorkOrder = workOrderDao.save(updatedWorkOrder);

        log.info("Successfully updated work order with ID: {}", id);
        return workOrderMapper.toResponse(savedWorkOrder);
    }

    @Override
    public WorkOrderResponse getById(Long id) {
        log.info("Fetching work order by ID: {}", id);

        WorkOrder workOrder = workOrderDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Work order not found with ID: " + id));

        return workOrderMapper.toResponse(workOrder);
    }

    @Override
    public WorkOrderResponse getByCode(String code) {
        log.info("Fetching work order by code: {}", code);

        WorkOrder workOrder = workOrderDao.findByCode(code)
            .orElseThrow(() -> new ResourceNotFoundException("Work order not found with code: " + code));

        return workOrderMapper.toResponse(workOrder);
    }

    @Override
    public List<WorkOrderResponse> getAll() {
        log.info("Fetching all work orders");
        return workOrderMapper.toResponse(workOrderDao.findAll());
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting work order with ID: {}", id);

        if (workOrderDao.existsById(id)) {
            throw new ResourceNotFoundException("Work order not found with ID: " + id);
        }

        workOrderDao.deleteById(id);
        log.info("Successfully deleted work order with ID: {}", id);
    }
}
