package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderLineItemsRepository extends JpaRepository<WorkOrderLineItems, Long> {
}
