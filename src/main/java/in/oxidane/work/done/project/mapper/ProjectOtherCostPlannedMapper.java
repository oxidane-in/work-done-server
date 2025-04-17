package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface ProjectOtherCostPlannedMapper {

    @Mapping(source = "projectId", target = "project", qualifiedByName = "toProject")
    @Mapping(source = "otherCostItemId", target = "otherCostItem", qualifiedByName = "toOtherCostItem")
    ProjectOtherCostPlanned toEntity(ProjectOtherCostPlannedRequest request);

    ProjectOtherCostPlannedResponse toResponse(ProjectOtherCostPlanned projectOtherCostPlanned);

    List<ProjectOtherCostPlannedResponse> toResponse(List<ProjectOtherCostPlanned> projectOtherCostPlannedList);

    @Mapping(source = "projectId", target = "project", qualifiedByName = "toProject")
    @Mapping(source = "otherCostItemId", target = "otherCostItem", qualifiedByName = "toOtherCostItem")
    ProjectOtherCostPlanned toUpdateEntityFromRequest(ProjectOtherCostPlannedRequest request, @MappingTarget ProjectOtherCostPlanned entity);
}
