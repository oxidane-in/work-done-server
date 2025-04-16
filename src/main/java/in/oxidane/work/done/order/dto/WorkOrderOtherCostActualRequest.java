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
public class WorkOrderOtherCostActualRequest {
    private Long workOrderOtherCostPlannedId;
    private BigDecimal woOtherCostActualAmount;
    private String woOtherCostActualRemark;
}
