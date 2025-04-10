package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;

import java.util.List;

public interface WorkOrderService {
    WorkOrderResponse create(WorkOrderRequest request);

    WorkOrderResponse update(Long id, WorkOrderRequest request);

    WorkOrderResponse getById(Long id);

    WorkOrderResponse getByCode(String code);

    List<WorkOrderResponse> getAll();

    void deleteById(Long id);
}
