package in.oxidane.work.done.material.dao;

import in.oxidane.work.done.material.entity.MaterialType;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for MaterialType entity.
 * Defines operations for accessing and manipulating MaterialType data.
 */
public interface MaterialTypeDao {

    /**
     * Create a new material type in the database
     *
     * @param materialType The material type to create
     * @return The created material type wrapped in Optional
     */
    Optional<MaterialType> create(MaterialType materialType);

    /**
     * Retrieve a material type by its ID
     *
     * @param id The ID of the material type to retrieve
     * @return The material type if found, otherwise empty Optional
     */
    Optional<MaterialType> getById(int id);

    /**
     * Retrieve all material types
     *
     * @return A list of all material types
     */
    List<MaterialType> getAll();

    /**
     * Update an existing material type
     *
     * @param materialType The material type with updated information
     * @return The updated material type wrapped in Optional
     */
    Optional<MaterialType> update(MaterialType materialType);

    /**
     * Delete a material type by its ID
     *
     * @param id The ID of the material type to delete
     */
    void delete(int id);

    /**
     * Check if a material type exists by its ID
     *
     * @param id The ID of the material type to check
     * @return True if the material type exists, false otherwise
     */
    boolean existsById(int id);
}
