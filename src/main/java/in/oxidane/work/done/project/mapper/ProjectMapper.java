package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
import in.oxidane.work.done.project.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface ProjectMapper {

    ProjectResponse toResponse(Project entity);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "toClient")
    @Mapping(target = "projectStatus", source = "projectStatusId", qualifiedByName = "toProjectStatus")
    Project toEntity(ProjectRequest request);

    List<ProjectResponse> toResponse(List<Project> projects);

    @Mapping(target = "client", source = "clientId", qualifiedByName = "toClient")
    @Mapping(target = "projectStatus", source = "projectStatusId", qualifiedByName = "toProjectStatus")
    Project toUpdateEntityFromRequest(ProjectRequest request, @MappingTarget Project entity);
}
