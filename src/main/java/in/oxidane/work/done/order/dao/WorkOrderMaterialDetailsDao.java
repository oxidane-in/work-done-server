package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrderMaterialDetails;

import java.util.List;
import java.util.Optional;

public interface WorkOrderMaterialDetailsDao {
    WorkOrderMaterialDetails save(WorkOrderMaterialDetails material);
    List<WorkOrderMaterialDetails> findAll();
    Optional<WorkOrderMaterialDetails> findById(Long id);
    List<WorkOrderMaterialDetails> findByWorkOrderId(Long workOrderId);
    List<WorkOrderMaterialDetails> findByWoLineItemId(Long woLineItemId);
    void deleteById(Long id);
    boolean existsById(Long id);
} 