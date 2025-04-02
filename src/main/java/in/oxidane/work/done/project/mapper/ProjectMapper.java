package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
import in.oxidane.work.done.project.entity.Client;
import in.oxidane.work.done.project.entity.Project;
import in.oxidane.work.done.project.entity.ProjectStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface ProjectMapper {

    ProjectResponse toResponse(Project entity);

    @Mapping(target = "projectId", ignore = true)
    @Mapping(target = "customer", expression = "java(createClient(request.getClientId()))")
    @Mapping(target = "projectStatus", expression = "java(createProjectStatus(request.getProjectStatusId()))")
    Project toEntity(ProjectRequest request);

    List<ProjectResponse> toResponse(List<Project> projects);

    @Mapping(target = "projectId", ignore = true)
    @Mapping(target = "customer", expression = "java(createClient(request.getClientId()))")
    @Mapping(target = "projectStatus", expression = "java(createProjectStatus(request.getProjectStatusId()))")
    Project toUpdateEntityFromRequest(ProjectRequest request, @MappingTarget Project entity);

    @Named("createClient")
    default Client createClient(Long id){
        return Client.builder().clientId(id).build();
    }

    @Named("createProjectStatus")
    default ProjectStatus createProjectStatus(Long id){
        return ProjectStatus.builder().projectStatusId(id).build();
    }
}
