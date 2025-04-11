package in.oxidane.work.done.material.service;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
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
    MaterialManufacturerResponse createMaterialManufacturer(MaterialManufacturerRequest request);

    /**
     * Get material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to retrieve
     * @return The MaterialManufacturerResponse if found
     * @throws ResourceNotFoundException if manufacturer not found
     */
    MaterialManufacturerResponse getMaterialManufacturerById(Long id);

    /**
     * Get all material manufacturers
     *
     * @return List of all MaterialManufacturerResponse objects
     */
    List<MaterialManufacturerResponse> getAllMaterialManufacturers();

    /**
     * Update an existing material manufacturer
     *
     * @param id The ID of the material manufacturer to update
     * @param request The MaterialManufacturerRequest containing updated information
     * @return The updated MaterialManufacturerResponse
     * @throws ResourceNotFoundException if manufacturer not found
     * @throws RuntimeException if update fails
     */
    MaterialManufacturerResponse updateMaterialManufacturer(Long id, MaterialManufacturerRequest request);

    /**
     * Delete material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to delete
     * @throws ResourceNotFoundException if manufacturer not found
     */
    void deleteMaterialManufacturer(Long id);
}
