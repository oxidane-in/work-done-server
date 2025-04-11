package in.oxidane.work.done.worker.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.worker.dao.WorkerTypeDao;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.entity.WorkerType;
import in.oxidane.work.done.worker.mapper.WorkerTypeMapper;
import in.oxidane.work.done.worker.service.WorkerTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the WorkerTypeService interface.
 * Provides business logic for worker type operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerTypeServiceImpl implements WorkerTypeService {

    private final WorkerTypeDao workerTypeDao;
    private final WorkerTypeMapper workerTypeMapper;

    @Override
    public WorkerTypeResponse createWorkerType(WorkerTypeRequest request) {
        log.debug("Creating worker type: {}", request.getWorkerTypeName());

        // Map request to entity
        WorkerType workerType = workerTypeMapper.toEntity(request);

        // Save entity
        return workerTypeDao.create(workerType)
            .map(workerTypeMapper::toResponse)
            .orElseThrow(() -> new RuntimeException("Failed to create worker type"));
    }

    @Override
    public WorkerTypeResponse getWorkerTypeById(Long id) {
        log.debug("Fetching worker type with ID: {}", id);

        return workerTypeDao.getById(id)
            .map(workerTypeMapper::toResponse)
            .orElseThrow(() -> new ResourceNotFoundException("Worker type not found with ID: " + id));
    }

    @Override
    public List<WorkerTypeResponse> getAllWorkerTypes() {
        log.debug("Fetching all worker types");

        return workerTypeMapper.toResponse(workerTypeDao.getAll());
    }

    @Override
    public WorkerTypeResponse updateWorkerType(Long id, WorkerTypeRequest request) {
        log.debug("Updating worker type with ID: {}", id);

        // Map request to entity
        WorkerType existingWorkerType = workerTypeDao.getById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Worker type not found with ID: " + id));

        WorkerType workerType = workerTypeMapper.toUpdateEntityFromRequest(request, existingWorkerType);

        log.debug("Updating worker type: {}", workerType);

        // Update entity
        return workerTypeDao.update(workerType)
            .map(workerTypeMapper::toResponse)
            .orElseThrow(() -> new ResourceNotFoundException("Worker type not found with ID: " + id));
    }

    @Override
    public void deleteWorkerType(Long id) {
        log.debug("Deleting worker type with ID: {}", id);

        if (!workerTypeDao.existsById(id)) {
            throw new ResourceNotFoundException("Worker type not found with ID: " + id);
        }

        workerTypeDao.delete(id);
    }
}
