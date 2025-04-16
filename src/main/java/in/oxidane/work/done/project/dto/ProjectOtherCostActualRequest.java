package in.oxidane.work.done.project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectOtherCostActualRequest {
    private Long projectOtherCostPlannedId;   // FK to the planned cost
    private BigDecimal projectOtherCostActualAmount;
    private String projectOtherCostActualRemark;
}
