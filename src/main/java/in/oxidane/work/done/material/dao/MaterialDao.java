package in.oxidane.work.done.material.dao;

import in.oxidane.work.done.material.entity.Material;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object (DAO) interface for the Material entity.
 * Defines operations for accessing and manipulating material data.
 */
public interface MaterialDao {

    /**
     * Creates a new material in the system.
     *
     * @param material The material object to create
     * @return An Optional containing the created material if successful, or empty if failed
     */
    Optional<Material> create(Material material);

    /**
     * Retrieves a material by its ID.
     *
     * @param materialId The ID of the material to retrieve
     * @return An Optional containing the material if found, or empty if not found
     */
    Optional<Material> getById(Integer materialId);

    /**
     * Retrieves all materials from the system.
     *
     * @return A list of all materials
     */
    List<Material> getAll();

    /**
     * Updates an existing material.
     *
     * @param materialId The ID of the material to update
     * @param material The updated material data
     * @return An Optional containing the updated material if successful, or empty if failed
     */
    Optional<Material> update(Integer materialId, Material material);

    /**
     * Deletes a material from the system.
     *
     * @param materialId The ID of the material to delete
     * @return true if the material was deleted, false otherwise
     */
    boolean delete(Integer materialId);

    /**
     * Checks if a material exists by its ID.
     *
     * @param materialId The ID to check
     * @return true if a material with the given ID exists, false otherwise
     */
    boolean existsById(Integer materialId);
}
