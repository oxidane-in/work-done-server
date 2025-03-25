package in.oxidane.work.done.worker.dao;

import in.oxidane.work.done.worker.entity.WorkerType;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for WorkerType entity.
 * Defines operations for accessing and manipulating WorkerType data.
 */
public interface WorkerTypeDao {

    /**
     * Create a new worker type in the database
     *
     * @param workerType The worker type to create
     * @return The created worker type wrapped in Optional
     */
    Optional<WorkerType> create(WorkerType workerType);

    /**
     * Retrieve a worker type by its ID
     *
     * @param id The ID of the worker type to retrieve
     * @return The worker type if found, otherwise empty Optional
     */
    Optional<WorkerType> getById(Long id);

    /**
     * Retrieve all worker types
     *
     * @return A list of all worker types
     */
    List<WorkerType> getAll();

    /**
     * Update an existing worker type
     *
     * @param workerType The worker type with updated information
     * @return The updated worker type wrapped in Optional
     */
    Optional<WorkerType> update(WorkerType workerType);

    /**
     * Delete a worker type by its ID
     *
     * @param id The ID of the worker type to delete
     */
    void delete(Long id);

    /**
     * Check if a worker type exists by its ID
     *
     * @param id The ID of the worker type to check
     * @return True if the worker type exists, false otherwise
     */
    boolean existsById(Long id);
}
