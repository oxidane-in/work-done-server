package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsResponse;

import java.util.List;

public interface WorkOrderMaterialDetailsService {
    WorkOrderMaterialDetailsResponse create(WorkOrderMaterialDetailsRequest request);

    WorkOrderMaterialDetailsResponse update(Long id, WorkOrderMaterialDetailsRequest request);

    WorkOrderMaterialDetailsResponse getById(Long id);

    List<WorkOrderMaterialDetailsResponse> getByWorkOrderId(Long workOrderId);

    List<WorkOrderMaterialDetailsResponse> getByLineItemId(Long lineItemId);

    List<WorkOrderMaterialDetailsResponse> getAll();

    void deleteById(Long id);
}
