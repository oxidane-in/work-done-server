package in.oxidane.work.done.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Project status name is mandatory")
    @Schema(description = "Name of the project status", example = "In Progress")
    private String projectStatusName;

    @Schema(description = "Description of the project status", example = "Project is currently in progress")
    private String projectStatusDesc;
}
