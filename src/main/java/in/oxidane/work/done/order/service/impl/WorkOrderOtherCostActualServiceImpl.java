package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.impl.WorkOrderOtherCostActualDoaImpl;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;
import in.oxidane.work.done.order.mapper.WorkOrderOtherCostActualMapper;
import in.oxidane.work.done.order.service.WorkOrderOtherCostActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderOtherCostActualServiceImpl implements WorkOrderOtherCostActualService {

    private final WorkOrderOtherCostActualDoaImpl workOrderOtherCostActualDoa;
    private final WorkOrderOtherCostActualMapper workOrderOtherCostActualMapper;

    @Override
    public WorkOrderOtherCostActualResponse createWorkOrderCostActual(WorkOrderOtherCostActualRequest request) {
        WorkOrderOtherCostActual entity = workOrderOtherCostActualMapper.toEntity(request);
        WorkOrderOtherCostActual savedEntity = workOrderOtherCostActualDoa.save(entity);
        return workOrderOtherCostActualMapper.toResponse(savedEntity);
    }

    @Override
    public WorkOrderOtherCostActualResponse getWorkOrderCostActualById(Long id) {
        WorkOrderOtherCostActual entity = workOrderOtherCostActualDoa.findById(id).
            orElseThrow(()->new ResourceNotFoundException("Not found WorkOrderCostActual with id : " + id));
        return workOrderOtherCostActualMapper.toResponse(entity);
    }

    @Override
    public List<WorkOrderOtherCostActualResponse> getAllWorkOrderCostActual() {
        List<WorkOrderOtherCostActual> allEntities = workOrderOtherCostActualDoa.findAll();
        return workOrderOtherCostActualMapper.toResponse(allEntities);
    }

    @Override
    public WorkOrderOtherCostActualResponse updateWorkOrderCostActualById(Long id, WorkOrderOtherCostActualRequest request) {
        WorkOrderOtherCostActual entity = workOrderOtherCostActualDoa.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Not found WorkOrderCostActual with id : " + id));

        WorkOrderOtherCostActual updateEntities = workOrderOtherCostActualMapper.toUpdateEntityFromRequest(request, entity);
        WorkOrderOtherCostActual savedEntities = workOrderOtherCostActualDoa.save(updateEntities);
        return workOrderOtherCostActualMapper.toResponse(savedEntities);
    }

    @Override
    public void deleteWorkOrderCostActual(Long id) {
        workOrderOtherCostActualDoa.delete(id);
    }
}
