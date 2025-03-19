package in.oxidane.work.done.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Project Status Request DTO")
public class ProjectStatusRequest {
    
    @Schema(description = "Name of the project status", example = "In Progress", required = true)
    private String projectStatusName;
    
    @Schema(description = "Handle or unique identifier for the project status", example = "in_progress")
    private String projectStatusHandle;
    
    @Schema(description = "Description of the project status", example = "Project is currently in progress")
    private String projectStatusDesc;
    
    @Schema(description = "Whether the project status is active", example = "true")
    private Boolean projectStatusIsActive;
} 