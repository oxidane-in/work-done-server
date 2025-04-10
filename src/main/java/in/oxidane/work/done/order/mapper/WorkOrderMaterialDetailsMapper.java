package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsResponse;
import in.oxidane.work.done.order.entity.WorkOrderMaterialDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderMaterialDetailsMapper {

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woLineItem", source = "woLineItemId", qualifiedByName = "toWorkOrderLineItems")
    WorkOrderMaterialDetails toEntity(WorkOrderMaterialDetailsRequest request);

    WorkOrderMaterialDetailsResponse toResponse(WorkOrderMaterialDetails entity);

    List<WorkOrderMaterialDetailsResponse> toResponse(List<WorkOrderMaterialDetails> items);

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woLineItem", source = "woLineItemId", qualifiedByName = "toWorkOrderLineItems")
    WorkOrderMaterialDetails toUpdateEntityFromRequest(WorkOrderMaterialDetailsRequest request,
                                                       @MappingTarget WorkOrderMaterialDetails entity);
}
