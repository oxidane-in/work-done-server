package in.oxidane.work.done.worker.dao.impl;

import in.oxidane.work.done.worker.dao.WorkerTypeDao;
import in.oxidane.work.done.worker.entity.WorkerType;
import in.oxidane.work.done.worker.repository.WorkerTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the WorkerTypeDao interface.
 * Provides data access operations for the WorkerType entity using JPA repository.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class WorkerTypeDaoImpl implements WorkerTypeDao {

    private final WorkerTypeRepository workerTypeRepository;

    @Override
    public Optional<WorkerType> create(WorkerType workerType) {
        log.debug("DAO - Creating worker type: {}", workerType.getWorkerTypeName());
        try {
            WorkerType savedType = workerTypeRepository.save(workerType);
            log.debug("DAO - Created worker type with ID: {}", savedType.getWorkerTypeId());
            return Optional.of(savedType);
        } catch (Exception e) {
            log.error("DAO - Error creating worker type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<WorkerType> getById(Long id) {
        log.debug("DAO - Fetching worker type with ID: {}", id);
        Optional<WorkerType> result = workerTypeRepository.findById(id);
        if (result.isPresent()) {
            log.debug("DAO - Found worker type: {}", result.get().getWorkerTypeName());
        } else {
            log.debug("DAO - Worker type with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<WorkerType> getAll() {
        log.debug("DAO - Fetching all worker types");
        List<WorkerType> types = workerTypeRepository.findAll();
        log.debug("DAO - Found {} worker types", types.size());
        return types;
    }

    @Override
    public Optional<WorkerType> update(WorkerType workerType) {
        log.debug("DAO - Updating worker type with ID: {}", workerType.getWorkerTypeId());

        // Check if the entity exists before updating
        if (!workerTypeRepository.existsById(workerType.getWorkerTypeId())) {
            log.debug("DAO - Worker type with ID {} not found for update", workerType.getWorkerTypeId());
            return Optional.empty();
        }

        try {
            WorkerType updatedType = workerTypeRepository.save(workerType);
            log.debug("DAO - Updated worker type: {}", updatedType.getWorkerTypeName());
            return Optional.of(updatedType);
        } catch (Exception e) {
            log.error("DAO - Error updating worker type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long id) {
        log.debug("DAO - Deleting worker type with ID: {}", id);

        // Check if the entity exists before deleting
        if (!workerTypeRepository.existsById(id)) {
            log.debug("DAO - Worker type with ID {} not found for deletion", id);
            return;
        }

        try {
            workerTypeRepository.deleteById(id);
            log.debug("DAO - Deleted worker type with ID: {}", id);
        } catch (Exception e) {
            log.error("DAO - Error deleting worker type: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(Long id) {
        log.debug("DAO - Checking if worker type exists with ID: {}", id);
        boolean exists = workerTypeRepository.existsById(id);
        log.debug("DAO - Worker type with ID {} exists: {}", id, exists);
        return exists;
    }
}
