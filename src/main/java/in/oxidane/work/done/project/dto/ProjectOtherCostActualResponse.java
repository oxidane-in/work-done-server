package in.oxidane.work.done.project.dto;

import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectOtherCostActualResponse {
    private Long projectOtherCostActualId;
    private ProjectOtherCostPlanned projectOtherCostPlanned;
    private BigDecimal projectOtherCostActualAmount;
    private String projectOtherCostActualRemark;
}
