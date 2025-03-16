package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.model.MaterialVendor;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for MaterialVendor entity.
 * Defines operations for accessing and manipulating MaterialVendor data.
 */
public interface MaterialVendorDao {

    /**
     * Create a new material vendor in the database
     *
     * @param materialVendor The material vendor to create
     * @return The created material vendor wrapped in Optional
     */
    Optional<MaterialVendor> create(MaterialVendor materialVendor);

    /**
     * Retrieve a material vendor by its ID
     *
     * @param id The ID of the material vendor to retrieve
     * @return The material vendor if found, otherwise empty Optional
     */
    Optional<MaterialVendor> getById(int id);

    /**
     * Retrieve all material vendors
     *
     * @return A list of all material vendors
     */
    List<MaterialVendor> getAll();

    /**
     * Update an existing material vendor
     *
     * @param materialVendor The material vendor with updated information
     * @return The updated material vendor wrapped in Optional
     */
    Optional<MaterialVendor> update(MaterialVendor materialVendor);

    /**
     * Delete a material vendor by its ID
     *
     * @param id The ID of the material vendor to delete
     */
    void delete(int id);

    /**
     * Check if a material vendor exists by its ID
     *
     * @param id The ID of the material vendor to check
     * @return True if the material vendor exists, false otherwise
     */
    boolean existsById(int id);
}
