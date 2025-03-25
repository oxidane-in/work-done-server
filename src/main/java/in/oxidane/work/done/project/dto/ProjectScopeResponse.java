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
@Schema(description = "Project Scope Response DTO")
public class ProjectScopeResponse {

    @Schema(description = "Unique identifier for the project scope", example = "1")
    private Long projectScopeId;

    @Schema(description = "Name of the project scope", example = "Commercial Building")
    private String projectScopeName;

    @Schema(description = "Handle or unique identifier for the project scope", example = "commercial_building")
    private String projectScopeHandle;

    @Schema(description = "Description of the project scope", example = "Scope for commercial building projects")
    private String projectScopeDesc;

    @Schema(description = "Whether the project scope is active", example = "true")
    private Boolean projectScopeIsActive;
}
