package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;

import java.util.List;
import java.util.Optional;

public interface WorkOrderOtherCostActualDao {
    WorkOrderOtherCostActual save(WorkOrderOtherCostActual entity);

    Optional<WorkOrderOtherCostActual> findById(Long id);

    List<WorkOrderOtherCostActual> findAll();

    void delete(Long id);

    boolean existById(Long id);
}
