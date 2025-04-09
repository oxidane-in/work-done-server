package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsResponse;
import in.oxidane.work.done.order.entity.WorkOrderWorkerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderWorkerDetailsMapper {

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woLineItem", source = "woLineItemId", qualifiedByName = "toWorkOrderLineItems")
    @Mapping(target = "woWorkerType", source = "woWorkerTypeId", qualifiedByName = "toWorkerType")
    WorkOrderWorkerDetails toEntity(WorkOrderWorkerDetailsRequest request);

    WorkOrderWorkerDetailsResponse toResponse(WorkOrderWorkerDetails entity);

    List<WorkOrderWorkerDetailsResponse> toResponse(List<WorkOrderWorkerDetails> items);

    @Mapping(target = "workOrder", source = "workOrderId", qualifiedByName = "toWorkOrder")
    @Mapping(target = "woLineItem", source = "woLineItemId", qualifiedByName = "toWorkOrderLineItems")
    @Mapping(target = "woWorkerType", source = "woWorkerTypeId", qualifiedByName = "toWorkerType")
    WorkOrderWorkerDetails toUpdateEntityFromRequest(WorkOrderWorkerDetailsRequest request,
                                                     @MappingTarget WorkOrderWorkerDetails entity);
}
