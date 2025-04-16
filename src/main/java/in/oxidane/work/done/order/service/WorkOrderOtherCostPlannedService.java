package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedResponse;

import java.util.List;

public interface WorkOrderOtherCostPlannedService {
    WorkOrderOtherCostPlannedResponse createWorkOrderOtherCostPlanned(WorkOrderOtherCostPlannedRequest request);

    WorkOrderOtherCostPlannedResponse getWorkOrderOtherCostPlannedById(Long id);

    List<WorkOrderOtherCostPlannedResponse> getAllWorkOrderOtherCostPlannedById();

    WorkOrderOtherCostPlannedResponse updateWorkOrderOtherCostPlannedById(Long id, WorkOrderOtherCostPlannedRequest request);

    void deleteWorkOrderOtherCostPlannedById(Long id);
}
