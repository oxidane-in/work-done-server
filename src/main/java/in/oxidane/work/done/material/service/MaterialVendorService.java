package in.oxidane.work.done.material.service;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;

import java.util.List;

/**
 * Service interface for MaterialVendor operations.
 * Defines business operations for managing material vendors.
 */
public interface MaterialVendorService {

    /**
     * Create a new material vendor
     *
     * @param request The MaterialVendorRequest containing vendor information
     * @return The created MaterialVendorResponse
     * @throws RuntimeException if creation fails
     */
    MaterialVendorResponse createMaterialVendor(MaterialVendorRequest request);

    /**
     * Get material vendor by ID
     *
     * @param id The ID of the material vendor to retrieve
     * @return The MaterialVendorResponse if found
     * @throws ResourceNotFoundException if vendor not found
     */
    MaterialVendorResponse getMaterialVendorById(Long id);

    /**
     * Get all material vendors
     *
     * @return List of all MaterialVendorResponse objects
     */
    List<MaterialVendorResponse> getAllMaterialVendors();

    /**
     * Update an existing material vendor
     *
     * @param id The ID of the material vendor to update
     * @param request The MaterialVendorRequest containing updated information
     * @return The updated MaterialVendorResponse
     * @throws ResourceNotFoundException if vendor not found
     * @throws RuntimeException if update fails
     */
    MaterialVendorResponse updateMaterialVendor(Long id, MaterialVendorRequest request);

    /**
     * Delete material vendor by ID
     *
     * @param id The ID of the material vendor to delete
     * @throws ResourceNotFoundException if vendor not found
     */
    void deleteMaterialVendor(Long id);
}
