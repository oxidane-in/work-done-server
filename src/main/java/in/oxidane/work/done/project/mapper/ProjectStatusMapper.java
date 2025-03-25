package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.entity.ProjectStatus;
import org.mapstruct.Mapper;

/**
 * Mapper class for converting between ProjectStatus entity and its DTOs.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface ProjectStatusMapper {

    /**
     * Converts a ProjectStatus entity to a ProjectStatusResponse DTO.
     *
     * @param entity The ProjectStatus entity to convert
     * @return The corresponding ProjectStatusResponse DTO, or null if the entity is null
     */
    public ProjectStatusResponse toResponse(ProjectStatus entity);

    /**
     * Converts a ProjectStatusRequest DTO to a ProjectStatus entity.
     *
     * @param request The ProjectStatusRequest DTO to convert
     * @return The corresponding ProjectStatus entity, or null if the request is null
     */
    public ProjectStatus toEntity(ProjectStatusRequest request);
}
