package in.oxidane.work.done.order.dto;


import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderOtherCostActualResponse {
    private Long woOtherCostActualId;
    private WorkOrderOtherCostPlanned workOrderOtherCostPlanned;
    private BigDecimal woOtherCostActualAmount;
    private String woOtherCostActualRemark;
}
