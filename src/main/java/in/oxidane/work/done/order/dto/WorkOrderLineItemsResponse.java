package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkOrderLineItemsResponse extends AuditableResponse {
    private Long woLineItemId;
    private WorkOrderResponse workOrder;
    private LineItemResponse woAllocatedLineItem;
    private BigDecimal woLineItemQty;
    private BigDecimal woLineItemRate;
    private BigDecimal woLineItemWorkerConstant;
}
