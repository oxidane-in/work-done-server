package in.oxidane.work.done.worker.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import in.oxidane.work.done.worker.entity.Worker;
import in.oxidane.work.done.worker.entity.WorkerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {WorkerTypeMapper.class})
public interface WorkerMapper {

    @Mapping(target = "workerType", source = "workerTypeId", qualifiedByName = "workerTypeIdToWorkerType")
    Worker toEntity(WorkerRequest request);

    WorkerResponse toResponse(Worker entity);

    List<WorkerResponse> toResponse(List<Worker> workers);

    @Mapping(target = "workerType", source = "workerTypeId", qualifiedByName = "workerTypeIdToWorkerType")
    Worker toUpdateEntityFromRequest(WorkerRequest request, @MappingTarget Worker entity);

    @Named("workerTypeIdToWorkerType")
    default WorkerType workerTypeIdToWorkerType(Long workerTypeId) {
        if (workerTypeId == null) {
            return null;
        }
        WorkerType workerType = new WorkerType();
        workerType.setWorkerTypeId(workerTypeId);
        return workerType;
    }
}
