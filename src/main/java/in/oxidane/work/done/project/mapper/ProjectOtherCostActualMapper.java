package in.oxidane.work.done.project.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostActual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface ProjectOtherCostActualMapper {

    @Mapping(source = "projectOtherCostPlannedId", target = "projectOtherCostPlanned", qualifiedByName = "toProjectOtherCostPlanned")
    ProjectOtherCostActual toEntity(ProjectOtherCostActualRequest request);

    ProjectOtherCostActualResponse toResponse(ProjectOtherCostActual projectOtherCostActual);

    List<ProjectOtherCostActualResponse> toResponse(List<ProjectOtherCostActual> projectOtherCostActuals);

    @Mapping(source = "projectOtherCostPlannedId", target = "projectOtherCostPlanned", qualifiedByName = "toProjectOtherCostPlanned")
    ProjectOtherCostActual toUpdateEntityFromRequest(ProjectOtherCostActualRequest request, @MappingTarget ProjectOtherCostActual entity);
}
