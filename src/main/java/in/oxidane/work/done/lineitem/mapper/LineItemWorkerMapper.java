package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerRequest;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerResponse;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.lineitem.entity.LineItemWorker;
import in.oxidane.work.done.worker.entity.WorkerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface LineItemWorkerMapper {

    @Mapping(target = "lineItemId", source = "lineItem.lineItemId")
    @Mapping(target = "workerTypeId", source = "workerType.workerTypeId")
    LineItemWorkerResponse toResponse(LineItemWorker entity);

    @Mapping(target = "lineItem.lineItemId", source = "lineItemId")
    @Mapping(target = "workerType.workerTypeId", source = "workerTypeId")
    LineItemWorker toEntity(LineItemWorkerRequest request);

    List<LineItemWorkerResponse> toResponse(List<LineItemWorker> lineItemWorkers);

    @Mapping(target = "lineItem", expression = "java(lineItemIdToLineItem(request.getLineItemId()))")
    @Mapping(target = "workerType", expression = "java(workerTypeIdToWorkerType(request.getWorkerTypeId()))")
    LineItemWorker toUpdateEntityFromRequest(LineItemWorkerRequest request);

    @Named("lineItemIdToLineItem")
    default LineItem lineItemIdToLineItem(Long lineItemId) {
        if (lineItemId == null) {
            return null;
        }
        return LineItem.builder().lineItemId(lineItemId).build();
    }

    @Named("workerTypeIdToWorkerType")
    default WorkerType workerTypeIdToWorkerType(Long workerTypeId) {
        if (workerTypeId == null) {
            return null;
        }
        return WorkerType.builder().workerTypeId(workerTypeId).build();
    }
}
