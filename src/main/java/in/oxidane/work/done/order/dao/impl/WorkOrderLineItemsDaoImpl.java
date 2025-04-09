package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderLineItemsDao;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import in.oxidane.work.done.order.repository.WorkOrderLineItemsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WorkOrderLineItemsDaoImpl implements WorkOrderLineItemsDao {

    private final WorkOrderLineItemsRepository repository;

    @Override
    public WorkOrderLineItems save(WorkOrderLineItems lineItem) {
        log.debug("Saving work order line item: {}", lineItem);
        return repository.save(lineItem);
    }

    @Override
    public List<WorkOrderLineItems> findAll() {
        log.debug("Fetching all work order line items");
        return repository.findAll();
    }

    @Override
    public Optional<WorkOrderLineItems> findById(Long id) {
        log.debug("Fetching work order line item by id: {}", id);
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting work order line item by id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        log.debug("Checking existence of work order line item by id: {}", id);
        return repository.existsById(id);
    }
}
