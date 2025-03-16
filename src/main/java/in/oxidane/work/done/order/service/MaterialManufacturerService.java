package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.order.dto.MaterialManufacturerResponse;
import java.util.List;

/**
 * Service interface for MaterialManufacturer operations.
 * Defines business operations for managing material manufacturers.
 */
public interface MaterialManufacturerService {

    /**
     * Create a new material manufacturer
     *
     * @param request The MaterialManufacturerRequest containing manufacturer information
     * @return The created MaterialManufacturerResponse
     * @throws RuntimeException if creation fails
     */
    MaterialManufacturerResponse create(MaterialManufacturerRequest request);

    /**
     * Get material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to retrieve
     * @return The MaterialManufacturerResponse if found
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if manufacturer not found
     */
    MaterialManufacturerResponse getById(int id);

    /**
     * Get all material manufacturers
     *
     * @return List of all MaterialManufacturerResponse objects
     */
    List<MaterialManufacturerResponse> getAll();

    /**
     * Update an existing material manufacturer
     *
     * @param id The ID of the material manufacturer to update
     * @param request The MaterialManufacturerRequest containing updated information
     * @return The updated MaterialManufacturerResponse
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if manufacturer not found
     * @throws RuntimeException if update fails
     */
    MaterialManufacturerResponse update(int id, MaterialManufacturerRequest request);

    /**
     * Delete material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to delete
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if manufacturer not found
     */
    void delete(int id);
} 