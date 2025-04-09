package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.order.dao.WorkOrderWorkerDetailsDao;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsResponse;
import in.oxidane.work.done.order.entity.WorkOrderWorkerDetails;
import in.oxidane.work.done.order.mapper.WorkOrderWorkerDetailsMapper;
import in.oxidane.work.done.order.service.WorkOrderWorkerDetailsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkOrderWorkerDetailsServiceImpl implements WorkOrderWorkerDetailsService {

    private final WorkOrderWorkerDetailsDao dao;
    private final WorkOrderWorkerDetailsMapper mapper;

    @Override
    @Transactional
    public WorkOrderWorkerDetailsResponse create(WorkOrderWorkerDetailsRequest request) {
        log.info("Creating new work order worker detail for work order ID: {} and line item ID: {}",
            request.getWorkOrderId(), request.getWoLineItemId());

        WorkOrderWorkerDetails workerDetail = mapper.toEntity(request);
        WorkOrderWorkerDetails savedWorkerDetail = dao.save(workerDetail);

        log.info("Created work order worker detail with ID: {}", savedWorkerDetail.getWoWorkerDetailId());
        return mapper.toResponse(savedWorkerDetail);
    }

    @Override
    @Transactional
    public WorkOrderWorkerDetailsResponse update(Long id, WorkOrderWorkerDetailsRequest request) {
        log.info("Updating work order worker detail with ID: {}", id);

        WorkOrderWorkerDetails existingWorkerDetail = dao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Work order worker detail not found with ID: " + id));

        WorkOrderWorkerDetails updatedWorkerDetail = mapper.toUpdateEntityFromRequest(request, existingWorkerDetail);
        WorkOrderWorkerDetails savedWorkerDetail = dao.save(updatedWorkerDetail);

        log.info("Updated work order worker detail with ID: {}", id);
        return mapper.toResponse(savedWorkerDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public WorkOrderWorkerDetailsResponse getById(Long id) {
        log.info("Fetching work order worker detail by ID: {}", id);

        return dao.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Work order worker detail not found with ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkOrderWorkerDetailsResponse> getByWorkOrderId(Long workOrderId) {
        log.info("Fetching work order worker details by work order ID: {}", workOrderId);
        return mapper.toResponse(dao.findByWorkOrderId(workOrderId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkOrderWorkerDetailsResponse> getByLineItemId(Long woLineItemId) {
        log.info("Fetching work order worker details by line item ID: {}", woLineItemId);
        return mapper.toResponse(dao.findByLineItemId(woLineItemId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkOrderWorkerDetailsResponse> getByWorkerTypeId(Long workerTypeId) {
        log.info("Fetching work order worker details by worker type ID: {}", workerTypeId);
        return mapper.toResponse(dao.findByWorkerTypeId(workerTypeId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkOrderWorkerDetailsResponse> getAll() {
        log.info("Fetching all work order worker details");
        return mapper.toResponse(dao.findAll());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting work order worker detail with ID: {}", id);

        if (!dao.existsById(id)) {
            throw new EntityNotFoundException("Work order worker detail not found with ID: " + id);
        }

        dao.deleteById(id);
        log.info("Deleted work order worker detail with ID: {}", id);
    }
}
