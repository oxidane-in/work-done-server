package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderOtherCostActualDao;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;
import in.oxidane.work.done.order.repository.WorkOrderOtherCostActualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WorkOrderOtherCostActualDoaImpl implements WorkOrderOtherCostActualDao {

    private final WorkOrderOtherCostActualRepository workOrderOtherCostActualRepository;

    @Override
    public WorkOrderOtherCostActual save(WorkOrderOtherCostActual entity) {
        return workOrderOtherCostActualRepository.save(entity);
    }

    @Override
    public Optional<WorkOrderOtherCostActual> findById(Long id) {
        return workOrderOtherCostActualRepository.findById(id);
    }

    @Override
    public List<WorkOrderOtherCostActual> findAll() {
        return workOrderOtherCostActualRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        workOrderOtherCostActualRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return workOrderOtherCostActualRepository.existsById(id);
    }
}
