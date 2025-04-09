package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderMaterialDetailsDao;
import in.oxidane.work.done.order.entity.WorkOrderMaterialDetails;
import in.oxidane.work.done.order.repository.WorkOrderMaterialDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WorkOrderMaterialDetailsDaoImpl implements WorkOrderMaterialDetailsDao {

    private final WorkOrderMaterialDetailsRepository repository;

    @Override
    public WorkOrderMaterialDetails save(WorkOrderMaterialDetails material) {
        log.debug("Saving work order material detail: {}", material);
        return repository.save(material);
    }

    @Override
    public List<WorkOrderMaterialDetails> findAll() {
        log.debug("Fetching all work order material details");
        return repository.findAll();
    }

    @Override
    public Optional<WorkOrderMaterialDetails> findById(Long id) {
        log.debug("Fetching work order material detail by id: {}", id);
        return repository.findById(id);
    }

    @Override
    public List<WorkOrderMaterialDetails> findByWorkOrderId(Long workOrderId) {
        log.debug("Fetching work order material details by work order id: {}", workOrderId);
        return repository.findByWorkOrder_WorkOrderId(workOrderId);
    }

    @Override
    public List<WorkOrderMaterialDetails> findByWoLineItemId(Long woLineItemId) {
        log.debug("Fetching work order material details by line item id: {}", woLineItemId);
        return repository.findByWoLineItem_WoLineItemId(woLineItemId);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting work order material detail by id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        log.debug("Checking if work order material detail exists by id: {}", id);
        return repository.existsById(id);
    }
}
