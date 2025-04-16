package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.WorkOrderOtherCostPlannedDao;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import in.oxidane.work.done.order.repository.WorkOrderOtherCostPlannedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WorkOrderOtherCostPlannedDaoImpl implements WorkOrderOtherCostPlannedDao {

    private final WorkOrderOtherCostPlannedRepository workOrderOtherCostPlannedRepository;

    @Override
    public WorkOrderOtherCostPlanned save(WorkOrderOtherCostPlanned entity) {
        return workOrderOtherCostPlannedRepository.save(entity);
    }

    @Override
    public Optional<WorkOrderOtherCostPlanned> findById(Long id) {
        return workOrderOtherCostPlannedRepository.findById(id);
    }

    @Override
    public List<WorkOrderOtherCostPlanned> findAll() {
        return workOrderOtherCostPlannedRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       workOrderOtherCostPlannedRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return workOrderOtherCostPlannedRepository.existsById(id);
    }
}
