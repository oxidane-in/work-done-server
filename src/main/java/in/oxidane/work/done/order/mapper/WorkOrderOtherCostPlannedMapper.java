package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderOtherCostPlannedMapper {

    // mapper - from request to entity
    @Mapping(source = "workOrderId", target = "workOrder", qualifiedByName = "toWorkOrder")
    @Mapping(source = "otherCostItemId", target = "otherCostItem", qualifiedByName = "toOtherCostItem")
    WorkOrderOtherCostPlanned toEntity(WorkOrderOtherCostPlannedRequest request);

    //mapper - from entity to response
    WorkOrderOtherCostPlannedResponse toResponse(WorkOrderOtherCostPlanned entity);

    //mapper - from entity list to response list
    List<WorkOrderOtherCostPlannedResponse> toResponse(List<WorkOrderOtherCostPlanned> entites);

    @Mapping(source = "workOrderId", target = "workOrder", qualifiedByName = "toWorkOrder")
    @Mapping(source = "otherCostItemId", target = "otherCostItem", qualifiedByName = "toOtherCostItem")
    WorkOrderOtherCostPlanned toUpdateEntityFromRequest(WorkOrderOtherCostPlannedRequest request, @MappingTarget WorkOrderOtherCostPlanned entity);
}
