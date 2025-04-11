package in.oxidane.work.done.worker.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import in.oxidane.work.done.worker.entity.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkerMapper {

    @Mapping(target = "workerType", source = "workerTypeId", qualifiedByName = "toWorkerType")
    Worker toEntity(WorkerRequest request);

    WorkerResponse toResponse(Worker entity);

    List<WorkerResponse> toResponse(List<Worker> workers);

    @Mapping(target = "workerType", source = "workerTypeId", qualifiedByName = "toWorkerType")
    Worker toUpdateEntityFromRequest(WorkerRequest request, @MappingTarget Worker entity);
}
