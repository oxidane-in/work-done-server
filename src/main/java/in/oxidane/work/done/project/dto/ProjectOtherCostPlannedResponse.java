package in.oxidane.work.done.project.dto;

import in.oxidane.work.done.project.entity.Project;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOtherCostPlannedResponse {
    private Long projectOtherCostPlannedId;
    private Project project;                // Full Project object
    private OtherCostItem otherCostItem;    // Full OtherCostItem object
    private BigDecimal projectOtherCostPlannedAmount;
    private String projectOtherCostPlannedRemark;
}
