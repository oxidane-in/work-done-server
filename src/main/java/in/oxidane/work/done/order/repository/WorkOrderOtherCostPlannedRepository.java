package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkOrderOtherCostPlannedRepository extends JpaRepository<WorkOrderOtherCostPlanned, Long> {
}
