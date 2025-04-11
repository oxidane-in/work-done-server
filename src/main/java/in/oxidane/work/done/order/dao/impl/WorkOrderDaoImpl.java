package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderDao;
import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.order.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class WorkOrderDaoImpl implements WorkOrderDao {

    private final WorkOrderRepository workOrderRepository;

    @Override
    public WorkOrder save(WorkOrder workOrder) {
        log.debug("Saving work order: {}", workOrder);
        return workOrderRepository.save(workOrder);
    }

    @Override
    public List<WorkOrder> findAll() {
        log.debug("Fetching all work orders");
        return workOrderRepository.findAll();
    }

    @Override
    public Optional<WorkOrder> findById(Long id) {
        log.debug("Fetching work order by id: {}", id);
        return workOrderRepository.findById(id);
    }

    @Override
    public Optional<WorkOrder> findByCode(String code) {
        log.debug("Fetching work order by code: {}", code);
        return workOrderRepository.findByWorkOrderCode(code);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting work order by id: {}", id);
        workOrderRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        log.debug("Checking if work order exists by id: {}", id);
        return workOrderRepository.existsById(id);
    }

    @Override
    public boolean existsByCode(String code) {
        log.debug("Checking if work order exists by code: {}", code);
        return workOrderRepository.existsByWorkOrderCode(code);
    }
}
