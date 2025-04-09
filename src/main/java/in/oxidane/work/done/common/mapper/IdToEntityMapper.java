package in.oxidane.work.done.common.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import in.oxidane.work.done.order.mapper.WorkOrderLineItemsMapper;
import in.oxidane.work.done.order.mapper.WorkOrderMapper;
import in.oxidane.work.done.worker.entity.WorkerType;
import in.oxidane.work.done.worker.mapper.WorkerTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapstructMapperConfig.class, uses = {WorkOrderMapper.class, WorkOrderLineItemsMapper.class, WorkerTypeMapper.class})
public interface IdToEntityMapper {

    @Named("toWorkOrder")
    default WorkOrder toWorkOrder(Long workOrderId) {
        if (workOrderId == null) return null;
        return WorkOrder.builder().workOrderId(workOrderId).build();
    }

    @Named("toWorkOrderLineItems")
    default WorkOrderLineItems toWorkOrderLineItems(Long lineItemId) {
        if (lineItemId == null) return null;
        return WorkOrderLineItems.builder().woLineItemId(lineItemId).build();
    }

    @Named("toWorkerType")
    default WorkerType toWorkerType(Long workerTypeId) {
        if (workerTypeId == null) return null;
        return WorkerType.builder().workerTypeId(workerTypeId).build();
    }
}
