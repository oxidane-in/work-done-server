package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrderMaterialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderMaterialDetailsRepository extends JpaRepository<WorkOrderMaterialDetails, Long> {
    List<WorkOrderMaterialDetails> findByWorkOrder_WorkOrderId(Long workOrderId);

    List<WorkOrderMaterialDetails> findByWoLineItem_WoLineItemId(Long woLineItemId);
}
