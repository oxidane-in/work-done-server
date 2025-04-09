package in.oxidane.work.done.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderLineItemsRequest {

    private Long workOrderId;

    private Long woAllocatedLineItemId;

    private BigDecimal woLineItemQty;

    private BigDecimal woLineItemRate;

    private BigDecimal woLineItemWorkerConstant;
}
