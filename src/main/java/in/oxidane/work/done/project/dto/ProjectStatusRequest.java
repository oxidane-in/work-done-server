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

    @Schema(description = "Name of the project status", example = "In Progress")
    private String projectStatusName;

    @Schema(description = "Description of the project status", example = "Project is currently in progress")
    private String projectStatusDesc;
}
