package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkOrderMaterialDetailsResponse extends AuditableResponse {
    private Long woMaterialDetailId;
    private WorkOrderResponse workOrder;
    private WorkOrderLineItemsResponse woLineItem;
    private Long woMaterialId;
    private String woMaterialName;
    private BigDecimal woMaterialConsumptionPerUOM;
    private BigDecimal totalConsumption;
} 