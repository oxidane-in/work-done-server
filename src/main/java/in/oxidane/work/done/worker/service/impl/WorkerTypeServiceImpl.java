package in.oxidane.work.done.worker.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.worker.dao.WorkerTypeDao;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.entity.WorkerType;
import in.oxidane.work.done.worker.mapper.WorkerTypeMapper;
import in.oxidane.work.done.worker.service.WorkerTypeService;
import in.oxidane.work.done.worker.validator.WorkerTypeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final WorkerTypeValidator validator;
    private final WorkerTypeMapper mapper;

    @Override
    @Transactional
    public WorkerTypeResponse createWorkerType(WorkerTypeRequest request) {
        log.debug("Service - Creating worker type: {}", request.getWorkerTypeName());

        // Validate request
        validator.validateForCreate(request);

        // Map request to entity
        WorkerType workerType = mapper.toEntity(request);

        // Save entity
        return workerTypeDao.create(workerType)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Failed to create worker type"));
    }

    @Override
    @Transactional(readOnly = true)
    public WorkerTypeResponse getWorkerTypeById(Long id) {
        log.debug("Service - Fetching worker type with ID: {}", id);

        return workerTypeDao.getById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Worker type not found with ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkerTypeResponse> getAllWorkerTypes() {
        log.debug("Service - Fetching all worker types");

        return mapper.toResponse(workerTypeDao.getAll());
    }

    @Override
    @Transactional
    public WorkerTypeResponse updateWorkerType(Long id, WorkerTypeRequest request) {
        log.debug("Service - Updating worker type with ID: {}", id);

        // Validate request
        validator.validateForUpdate(request, id);

        // Map request to entity
        WorkerType workerType = mapper.toEntity(request);
        workerType.toBuilder().workerTypeId(id).build();

        // Update entity
        return workerTypeDao.update(workerType)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Worker type not found with ID: " + id));
    }

    @Override
    @Transactional
    public void deleteWorkerType(Long id) {
        log.debug("Service - Deleting worker type with ID: {}", id);

        if (!workerTypeDao.existsById(id)) {
            throw new ResourceNotFoundException("Worker type not found with ID: " + id);
        }

        workerTypeDao.delete(id);
    }
}
