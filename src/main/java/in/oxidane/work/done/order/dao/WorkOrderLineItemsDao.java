package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.WorkOrderLineItems;

import java.util.List;
import java.util.Optional;

public interface WorkOrderLineItemsDao {
    WorkOrderLineItems save(WorkOrderLineItems lineItem);

    List<WorkOrderLineItems> findAll();

    Optional<WorkOrderLineItems> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
}
