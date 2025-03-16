package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.MaterialTypeRequest;
import in.oxidane.work.done.order.dto.MaterialTypeResponse;
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
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if type not found
     */
    MaterialTypeResponse getMaterialTypeById(int id);

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
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if type not found
     * @throws RuntimeException if update fails
     */
    MaterialTypeResponse updateMaterialType(int id, MaterialTypeRequest request);

    /**
     * Delete material type by ID
     *
     * @param id The ID of the material type to delete
     * @throws in.oxidane.work.done.exception.ResourceNotFoundException if type not found
     */
    void deleteMaterialType(int id);
}
