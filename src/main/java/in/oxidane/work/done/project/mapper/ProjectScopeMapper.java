package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.entity.ProjectScope;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper class for converting between ProjectScope entity and its DTOs.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface ProjectScopeMapper {

    /**
     * Converts a ProjectScope entity to a ProjectScopeResponse DTO.
     *
     * @param entity The ProjectScope entity to convert
     * @return The corresponding ProjectScopeResponse DTO, or null if the entity is null
     */
    ProjectScopeResponse toResponse(ProjectScope entity);

    /**
     * Converts a ProjectScopeRequest DTO to a ProjectScope entity.
     *
     * @param request The ProjectScopeRequest DTO to convert
     * @return The corresponding ProjectScope entity, or null if the request is null
     */
    ProjectScope toEntity(ProjectScopeRequest request);

    ProjectScope toUpdateEntityFromRequest(ProjectScopeRequest request, @MappingTarget ProjectScope entity);
}
