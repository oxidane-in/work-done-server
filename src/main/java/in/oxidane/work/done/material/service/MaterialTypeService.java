package in.oxidane.work.done.material.service;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import java.util.List;

/**
 * Service interface for MaterialType operations.
 * Defines business operations for managing material types.
 */
public interface MaterialTypeService {

    /**
     * Create a new material type
     *
     * @param request The MaterialTypeRequest containing type information
     * @return The created MaterialTypeResponse
     * @throws RuntimeException if creation fails
     */
    MaterialTypeResponse createMaterialType(MaterialTypeRequest request);

    /**
     * Get material type by ID
     *
     * @param id The ID of the material type to retrieve
     * @return The MaterialTypeResponse if found
     * @throws ResourceNotFoundException if type not found
     */
    MaterialTypeResponse getMaterialTypeById(Long id);

    /**
     * Get all material types
     *
     * @return List of all MaterialTypeResponse objects
     */
    List<MaterialTypeResponse> getAllMaterialTypes();

    /**
     * Update an existing material type
     *
     * @param id The ID of the material type to update
     * @param request The MaterialTypeRequest containing updated information
     * @return The updated MaterialTypeResponse
     * @throws ResourceNotFoundException if type not found
     * @throws RuntimeException if update fails
     */
    MaterialTypeResponse updateMaterialType(Long id, MaterialTypeRequest request);

    /**
     * Delete material type by ID
     *
     * @param id The ID of the material type to delete
     * @throws ResourceNotFoundException if type not found
     */
    void deleteMaterialType(Long id);
}
