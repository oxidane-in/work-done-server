package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderOtherCostActualRepository extends JpaRepository<WorkOrderOtherCostActual, Long> {
}
