package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkOrderWorkerDetailsResponse extends AuditableResponse {
    private Long woWorkerDetailId;
    private WorkOrderResponse workOrder;
    private WorkOrderLineItemsResponse woLineItem;
    private WorkerTypeResponse woWorkerType;
    private BigDecimal woWorkerTypeRequiredPerUOM;
    private BigDecimal woWorkerTypeRatePerHajri;
}
