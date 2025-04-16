package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderOtherCostPlannedResponse {
    private Long woOtherCostPlannedId;
    private WorkOrder workOrder;
    private OtherCostItem otherCostItem;
    private BigDecimal woOtherCostPlannedAmount;
    private String woOtherCostPlannedRemark;
}
