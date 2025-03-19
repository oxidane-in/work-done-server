package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.entity.ProjectStatus;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between ProjectStatus entity and its DTOs.
 */
@Component
public class ProjectStatusMapper {

    /**
     * Converts a ProjectStatus entity to a ProjectStatusResponse DTO.
     *
     * @param entity The ProjectStatus entity to convert
     * @return The corresponding ProjectStatusResponse DTO, or null if the entity is null
     */
    public ProjectStatusResponse toResponse(ProjectStatus entity) {
        if (entity == null) {
            return null;
        }
        
        return ProjectStatusResponse.builder()
            .projectStatusId(entity.getProjectStatusId())
            .projectStatusName(entity.getProjectStatusName())
            .projectStatusHandle(entity.getProjectStatusHandle())
            .projectStatusDesc(entity.getProjectStatusDesc())
            .projectStatusIsActive(entity.getProjectStatusIsActive())
            .build();
    }

    /**
     * Converts a ProjectStatusRequest DTO to a ProjectStatus entity.
     *
     * @param request The ProjectStatusRequest DTO to convert
     * @return The corresponding ProjectStatus entity, or null if the request is null
     */
    public ProjectStatus toEntity(ProjectStatusRequest request) {
        if (request == null) {
            return null;
        }
        
        return ProjectStatus.builder()
            .projectStatusName(request.getProjectStatusName())
            .projectStatusHandle(request.getProjectStatusHandle())
            .projectStatusDesc(request.getProjectStatusDesc())
            .projectStatusIsActive(request.getProjectStatusIsActive() != null ? request.getProjectStatusIsActive() : true)
            .build();
    }
} 