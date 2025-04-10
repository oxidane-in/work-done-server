package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
    Optional<WorkOrder> findByWorkOrderCode(String workOrderCode);

    boolean existsByWorkOrderCode(String workOrderCode);
}
