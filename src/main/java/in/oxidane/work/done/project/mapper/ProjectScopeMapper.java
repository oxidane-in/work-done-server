package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.entity.ProjectScope;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between ProjectScope entity and its DTOs.
 */
@Component
public class ProjectScopeMapper {

    /**
     * Converts a ProjectScope entity to a ProjectScopeResponse DTO.
     *
     * @param entity The ProjectScope entity to convert
     * @return The corresponding ProjectScopeResponse DTO, or null if the entity is null
     */
    public ProjectScopeResponse toResponse(ProjectScope entity) {
        if (entity == null) {
            return null;
        }

        return ProjectScopeResponse.builder()
            .projectScopeId(entity.getProjectScopeId())
            .projectScopeName(entity.getProjectScopeName())
            .projectScopeHandle(entity.getProjectScopeHandle())
            .projectScopeDesc(entity.getProjectScopeDesc())
            .build();
    }

    /**
     * Converts a ProjectScopeRequest DTO to a ProjectScope entity.
     *
     * @param request The ProjectScopeRequest DTO to convert
     * @return The corresponding ProjectScope entity, or null if the request is null
     */
    public ProjectScope toEntity(ProjectScopeRequest request) {
        if (request == null) {
            return null;
        }

        return ProjectScope.builder()
            .projectScopeName(request.getProjectScopeName())
            .projectScopeHandle(request.getProjectScopeHandle())
            .projectScopeDesc(request.getProjectScopeDesc())
            .build();
    }
}
