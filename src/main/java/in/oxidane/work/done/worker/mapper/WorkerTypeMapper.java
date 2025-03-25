package in.oxidane.work.done.worker.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.entity.WorkerType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface WorkerTypeMapper {

    WorkerTypeResponse toResponse(WorkerType entity);

    WorkerType toEntity(WorkerTypeRequest request);

    List<WorkerTypeResponse> toResponse(List<WorkerType> workerTypes);
}
