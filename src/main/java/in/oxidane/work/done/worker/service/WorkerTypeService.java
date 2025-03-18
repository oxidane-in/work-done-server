package in.oxidane.work.done.worker.service;

import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;

import java.util.List;

/**
 * Service interface for WorkerType operations.
 * Defines business operations for worker types.
 */
public interface WorkerTypeService {

    /**
     * Create a new worker type
     *
     * @param request The worker type request data
     * @return The created worker type response
     */
    WorkerTypeResponse createWorkerType(WorkerTypeRequest request);

    /**
     * Get a worker type by ID
     *
     * @param id The ID of the worker type to retrieve
     * @return The worker type response if found
     */
    WorkerTypeResponse getWorkerTypeById(int id);

    /**
     * Get all worker types
     *
     * @return List of all worker type responses
     */
    List<WorkerTypeResponse> getAllWorkerTypes();

    /**
     * Update an existing worker type
     *
     * @param id The ID of the worker type to update
     * @param request The updated worker type data
     * @return The updated worker type response
     */
    WorkerTypeResponse updateWorkerType(int id, WorkerTypeRequest request);

    /**
     * Delete a worker type by ID
     *
     * @param id The ID of the worker type to delete
     */
    void deleteWorkerType(int id);
} 