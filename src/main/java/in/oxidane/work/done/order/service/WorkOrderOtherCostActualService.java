package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualResponse;

import java.util.List;

public interface WorkOrderOtherCostActualService {
    WorkOrderOtherCostActualResponse createWorkOrderCostActual(WorkOrderOtherCostActualRequest request);

    WorkOrderOtherCostActualResponse getWorkOrderCostActualById(Long id);

    List<WorkOrderOtherCostActualResponse> getAllWorkOrderCostActual();

    WorkOrderOtherCostActualResponse updateWorkOrderCostActualById(Long id, WorkOrderOtherCostActualRequest request);

    void deleteWorkOrderCostActual(Long id);
}
