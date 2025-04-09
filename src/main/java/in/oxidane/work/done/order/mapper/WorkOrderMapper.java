package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import in.oxidane.work.done.order.entity.WorkOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderMapper {

    @Mapping(target = "project", source = "projectId", qualifiedByName = "toProject")
    WorkOrder toEntity(WorkOrderRequest request);

    WorkOrderResponse toResponse(WorkOrder entity);

    List<WorkOrderResponse> toResponse(List<WorkOrder> workOrders);

    @Mapping(target = "project", source = "projectId", qualifiedByName = "toProject")
    WorkOrder toUpdateEntityFromRequest(WorkOrderRequest request, @MappingTarget WorkOrder entity);
}
