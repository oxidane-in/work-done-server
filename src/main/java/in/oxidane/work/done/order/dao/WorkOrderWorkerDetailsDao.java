package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrderWorkerDetails;

import java.util.List;
import java.util.Optional;

public interface WorkOrderWorkerDetailsDao {
    WorkOrderWorkerDetails save(WorkOrderWorkerDetails workerDetail);

    List<WorkOrderWorkerDetails> findAll();

    Optional<WorkOrderWorkerDetails> findById(Long id);

    List<WorkOrderWorkerDetails> findByWorkOrderId(Long workOrderId);

    List<WorkOrderWorkerDetails> findByLineItemId(Long woLineItemId);

    List<WorkOrderWorkerDetails> findByWorkerTypeId(Long woWorkerTypeId);

    void deleteById(Long id);

    boolean existsById(Long id);
}
