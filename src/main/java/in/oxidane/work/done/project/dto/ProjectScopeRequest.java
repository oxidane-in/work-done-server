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
@Schema(description = "Project Scope Request DTO")
public class ProjectScopeRequest {

    @NotBlank(message = "Project scope name is mandatory")
    @Schema(description = "Name of the project scope", example = "Commercial Building")
    private String projectScopeName;

    @Schema(description = "Description of the project scope", example = "Scope for commercial building projects")
    private String projectScopeDesc;
}
