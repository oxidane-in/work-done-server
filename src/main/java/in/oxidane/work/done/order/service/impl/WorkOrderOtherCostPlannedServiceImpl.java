package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.impl.WorkOrderOtherCostPlannedDaoImpl;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import in.oxidane.work.done.order.mapper.WorkOrderOtherCostPlannedMapper;
import in.oxidane.work.done.order.service.WorkOrderOtherCostPlannedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderOtherCostPlannedServiceImpl implements WorkOrderOtherCostPlannedService {

    private final WorkOrderOtherCostPlannedDaoImpl workOrderOtherCostPlannedDao;
    private final WorkOrderOtherCostPlannedMapper workOrderOtherCostPlannedMapper;

    @Override
    public WorkOrderOtherCostPlannedResponse createWorkOrderOtherCostPlanned(WorkOrderOtherCostPlannedRequest request) {
        WorkOrderOtherCostPlanned entity = workOrderOtherCostPlannedMapper.toEntity(request);
        WorkOrderOtherCostPlanned savedEntity = workOrderOtherCostPlannedDao.save(entity);
        return workOrderOtherCostPlannedMapper.toResponse(savedEntity);
    }

    @Override
    public WorkOrderOtherCostPlannedResponse getWorkOrderOtherCostPlannedById(Long id) {
        WorkOrderOtherCostPlanned entity = workOrderOtherCostPlannedDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found WorkOrderOtherCostPlanned with id: " + id));
        return workOrderOtherCostPlannedMapper.toResponse(entity);
    }

    @Override
    public List<WorkOrderOtherCostPlannedResponse> getAllWorkOrderOtherCostPlannedById() {
        List<WorkOrderOtherCostPlanned> allEntities = workOrderOtherCostPlannedDao.findAll();
        return workOrderOtherCostPlannedMapper.toResponse(allEntities);
    }

    @Override
    public WorkOrderOtherCostPlannedResponse updateWorkOrderOtherCostPlannedById(Long id, WorkOrderOtherCostPlannedRequest request) {
        WorkOrderOtherCostPlanned entity = workOrderOtherCostPlannedDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found WorkOrderOtherCostPlanned with id: " + id));

        WorkOrderOtherCostPlanned updatedEntity = workOrderOtherCostPlannedMapper.toUpdateEntityFromRequest(request, entity);
        WorkOrderOtherCostPlanned savedEntity = workOrderOtherCostPlannedDao.save(updatedEntity);
        return workOrderOtherCostPlannedMapper.toResponse(savedEntity);
    }

    @Override
    public void deleteWorkOrderOtherCostPlannedById(Long id) {
        if (!workOrderOtherCostPlannedDao.existById(id)) {
            throw new ResourceNotFoundException("Not found WorkOrderOtherCostPlanned with id: " + id);
        }
        workOrderOtherCostPlannedDao.delete(id);
    }
}
