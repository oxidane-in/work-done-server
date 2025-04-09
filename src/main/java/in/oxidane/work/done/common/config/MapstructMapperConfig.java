package in.oxidane.work.done.common.config;

import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import in.oxidane.work.done.worker.entity.WorkerType;
import org.mapstruct.MapperConfig;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public class MapstructMapperConfig {

    @Named("workOrderIdToWorkOrder")
    public WorkOrder workOrderIdToWorkOrder(Long workOrderId) {
        if (workOrderId == null) {
            return null;
        }
        return WorkOrder.builder()
            .workOrderId(workOrderId)
            .build();
    }

    @Named("lineItemIdToWorkOrderLineItems")
    public WorkOrderLineItems lineItemIdToWorkOrderLineItems(Long lineItemId) {
        if (lineItemId == null) {
            return null;
        }
        return WorkOrderLineItems.builder()
            .woLineItemId(lineItemId)
            .build();
    }

    @Named("workerTypeIdToWorkerType")
    public WorkerType workerTypeIdToWorkerType(Long workerTypeId) {
        if (workerTypeId == null) {
            return null;
        }

        return WorkerType.builder()
            .workerTypeId(workerTypeId)
            .build();
    }
}
