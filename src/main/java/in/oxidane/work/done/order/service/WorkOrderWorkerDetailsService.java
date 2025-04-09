package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsResponse;

import java.util.List;

public interface WorkOrderWorkerDetailsService {
    WorkOrderWorkerDetailsResponse create(WorkOrderWorkerDetailsRequest request);

    WorkOrderWorkerDetailsResponse update(Long id, WorkOrderWorkerDetailsRequest request);

    WorkOrderWorkerDetailsResponse getById(Long id);

    List<WorkOrderWorkerDetailsResponse> getByWorkOrderId(Long workOrderId);

    List<WorkOrderWorkerDetailsResponse> getByLineItemId(Long woLineItemId);

    List<WorkOrderWorkerDetailsResponse> getByWorkerTypeId(Long workerTypeId);

    List<WorkOrderWorkerDetailsResponse> getAll();

    void deleteById(Long id);
}
