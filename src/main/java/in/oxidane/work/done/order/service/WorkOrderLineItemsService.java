package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderLineItemsRequest;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsResponse;

import java.util.List;

public interface WorkOrderLineItemsService {
    WorkOrderLineItemsResponse create(WorkOrderLineItemsRequest request);

    WorkOrderLineItemsResponse update(Long id, WorkOrderLineItemsRequest request);

    WorkOrderLineItemsResponse getById(Long id);

    List<WorkOrderLineItemsResponse> getAll();

    void deleteById(Long id);
}
