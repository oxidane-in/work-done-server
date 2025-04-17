package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;

import java.util.List;
import java.util.Optional;

public interface WorkOrderOtherCostPlannedDao {
    WorkOrderOtherCostPlanned save(WorkOrderOtherCostPlanned entity);

    Optional<WorkOrderOtherCostPlanned> findById(Long id);

    List<WorkOrderOtherCostPlanned> findAll();

    void delete(Long id);

    boolean existById(Long id);
}
