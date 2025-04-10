package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrderWorkerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderWorkerDetailsRepository extends JpaRepository<WorkOrderWorkerDetails, Long> {
    List<WorkOrderWorkerDetails> findByWorkOrder_WorkOrderId(Long workOrderId);

    List<WorkOrderWorkerDetails> findByWoLineItem_WoLineItemId(Long woLineItemId);

    List<WorkOrderWorkerDetails> findByWoWorkerType_WorkerTypeId(Long woWorkerTypeId);
}
