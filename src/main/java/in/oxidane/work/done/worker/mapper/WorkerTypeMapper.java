package in.oxidane.work.done.worker.mapper;

import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.entity.WorkerType;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between WorkerType entity and DTOs.
 */
@Component
public class WorkerTypeMapper {

    /**
     * Convert WorkerType entity to WorkerTypeResponse DTO
     *
     * @param entity The WorkerType entity
     * @return WorkerTypeResponse DTO
     */
    public WorkerTypeResponse toResponse(WorkerType entity) {
        if (entity == null) {
            return null;
        }

        return WorkerTypeResponse.builder()
                .workerTypeId(entity.getWorkerTypeId())
                .workerTypeName(entity.getWorkerTypeName())
                .workerTypeRate(entity.getWorkerTypeRate())
                .workerTypeHandle(entity.getWorkerTypeHandle())
                .workerTypeDesc(entity.getWorkerTypeDesc())
                .workerTypeIsActive(entity.getWorkerTypeIsActive())
                .build();
    }

    /**
     * Convert WorkerTypeRequest DTO to WorkerType entity
     *
     * @param request The WorkerTypeRequest DTO
     * @return WorkerType entity
     */
    public WorkerType toEntity(WorkerTypeRequest request) {
        if (request == null) {
            return null;
        }

        return WorkerType.builder()
                .workerTypeName(request.getWorkerTypeName())
                .workerTypeRate(request.getWorkerTypeRate())
                .workerTypeHandle(request.getWorkerTypeHandle())
                .workerTypeDesc(request.getWorkerTypeDesc())
                .workerTypeIsActive(request.getWorkerTypeIsActive())
                .build();
    }
} 