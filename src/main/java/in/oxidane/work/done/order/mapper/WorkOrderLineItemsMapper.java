package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsRequest;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsResponse;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderLineItemsMapper {

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woAllocatedLineItem", source = "woAllocatedLineItemId", qualifiedByName = "toLineItem")
    WorkOrderLineItems toEntity(WorkOrderLineItemsRequest request);

    WorkOrderLineItemsResponse toResponse(WorkOrderLineItems entity);

    List<WorkOrderLineItemsResponse> toResponse(List<WorkOrderLineItems> items);

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woAllocatedLineItem", source = "woAllocatedLineItemId", qualifiedByName = "toLineItem")
    WorkOrderLineItems toUpdateEntityFromRequest(WorkOrderLineItemsRequest request, @MappingTarget WorkOrderLineItems entity);
}
