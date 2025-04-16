package in.oxidane.work.done.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOtherCostPlannedRequest {
    private Long projectId;             // FK to Project
    private Long otherCostItemId;       // FK to OtherCostItem
    private BigDecimal projectOtherCostPlannedAmount;
    private String projectOtherCostPlannedRemark;
}
