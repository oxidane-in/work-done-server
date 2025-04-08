package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.project.entity.Project;
import in.oxidane.work.done.project.mapper.ProjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {ProjectMapper.class})
public interface WorkOrderMapper {

    @Mapping(target = "project", source = "projectId", qualifiedByName = "projectIdToProject")
    WorkOrder toEntity(WorkOrderRequest request);

    WorkOrderResponse toResponse(WorkOrder entity);

    List<WorkOrderResponse> toResponse(List<WorkOrder> workOrders);

    @Mapping(target = "project", source = "projectId", qualifiedByName = "projectIdToProject")
    WorkOrder toUpdateEntityFromRequest(WorkOrderRequest request, @MappingTarget WorkOrder entity);

    @Named("projectIdToProject")
    default Project projectIdToProject(Long projectId) {
        if (projectId == null) {
            return null;
        }
        return Project.builder()
            .projectId(projectId)
            .build();
    }
}
