package in.oxidane.work.done.material.service;

import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.exception.ResourceNotFoundException;

import java.util.List;

/**
 * Service interface for Material operations.
 * Defines business operations for managing materials.
 */
public interface MaterialService {

    /**
     * Creates a new material.
     *
     * @param request The material data for creation
     * @return The created material response
     */
    MaterialResponse createMaterial(MaterialRequest request);

    /**
     * Retrieves a material by its ID.
     *
     * @param materialId The ID of the material to retrieve
     * @return The material response
     * @throws ResourceNotFoundException if the material is not found
     */
    MaterialResponse getMaterialById(Integer materialId) throws ResourceNotFoundException;

    /**
     * Retrieves all materials.
     *
     * @return A list of all material responses
     */
    List<MaterialResponse> getAllMaterials();

    /**
     * Updates an existing material.
     *
     * @param materialId The ID of the material to update
     * @param request The material data for update
     * @return The updated material response
     * @throws ResourceNotFoundException if the material is not found
     */
    MaterialResponse updateMaterial(Integer materialId, MaterialRequest request) throws ResourceNotFoundException;

    /**
     * Deletes a material by its ID.
     *
     * @param materialId The ID of the material to delete
     * @throws ResourceNotFoundException if the material is not found
     */
    void deleteMaterial(Integer materialId) throws ResourceNotFoundException;
}
