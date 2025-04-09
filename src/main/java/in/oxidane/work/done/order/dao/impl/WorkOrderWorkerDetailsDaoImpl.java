package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderWorkerDetailsDao;
import in.oxidane.work.done.order.entity.WorkOrderWorkerDetails;
import in.oxidane.work.done.order.repository.WorkOrderWorkerDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WorkOrderWorkerDetailsDaoImpl implements WorkOrderWorkerDetailsDao {

    private final WorkOrderWorkerDetailsRepository repository;

    @Override
    public WorkOrderWorkerDetails save(WorkOrderWorkerDetails workerDetail) {
        log.debug("Saving work order worker detail: {}", workerDetail);
        return repository.save(workerDetail);
    }

    @Override
    public List<WorkOrderWorkerDetails> findAll() {
        log.debug("Fetching all work order worker details");
        return repository.findAll();
    }

    @Override
    public Optional<WorkOrderWorkerDetails> findById(Long id) {
        log.debug("Fetching work order worker detail by id: {}", id);
        return repository.findById(id);
    }

    @Override
    public List<WorkOrderWorkerDetails> findByWorkOrderId(Long workOrderId) {
        log.debug("Fetching work order worker details by work order id: {}", workOrderId);
        return repository.findByWorkOrder_WorkOrderId(workOrderId);
    }

    @Override
    public List<WorkOrderWorkerDetails> findByLineItemId(Long woLineItemId) {
        log.debug("Fetching work order worker details by line item id: {}", woLineItemId);
        return repository.findByWoLineItem_WoLineItemId(woLineItemId);
    }

    @Override
    public List<WorkOrderWorkerDetails> findByWorkerTypeId(Long woWorkerTypeId) {
        log.debug("Fetching work order worker details by worker type id: {}", woWorkerTypeId);
        return repository.findByWoWorkerType_WorkerTypeId(woWorkerTypeId);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting work order worker detail by id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        log.debug("Checking if work order worker detail exists by id: {}", id);
        return repository.existsById(id);
    }
}
