package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrder;

import java.util.List;
import java.util.Optional;

public interface WorkOrderDao {
    WorkOrder save(WorkOrder workOrder);

    List<WorkOrder> findAll();

    Optional<WorkOrder> findById(Long id);

    Optional<WorkOrder> findByCode(String code);

    void deleteById(Long id);

    boolean existsById(Long id);

    boolean existsByCode(String code);
}
