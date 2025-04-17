package in.oxidane.work.done.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderOtherCostPlannedRequest {
    private Long workOrderId;
    private Long otherCostItemId;
    private BigDecimal woOtherCostPlannedAmount;
    private String woOtherCostPlannedRemark;
}
