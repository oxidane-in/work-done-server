package in.oxidane.work.done.material.dao;

import in.oxidane.work.done.material.entity.MaterialManufacturer;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for MaterialManufacturer entity.
 * Defines operations for accessing and manipulating MaterialManufacturer data.
 */
public interface MaterialManufacturerDao {

    /**
     * Create a new material manufacturer in the database
     *
     * @param materialManufacturer The material manufacturer to create
     * @return The created material manufacturer wrapped in Optional
     */
    Optional<MaterialManufacturer> create(MaterialManufacturer materialManufacturer);

    /**
     * Retrieve a material manufacturer by its ID
     *
     * @param id The ID of the material manufacturer to retrieve
     * @return The material manufacturer if found, otherwise empty Optional
     */
    Optional<MaterialManufacturer> getById(int id);

    /**
     * Retrieve all material manufacturers
     *
     * @return A list of all material manufacturers
     */
    List<MaterialManufacturer> getAll();

    /**
     * Update an existing material manufacturer
     *
     * @param materialManufacturer The material manufacturer with updated information
     * @return The updated material manufacturer wrapped in Optional
     */
    Optional<MaterialManufacturer> update(MaterialManufacturer materialManufacturer);

    /**
     * Delete a material manufacturer by its ID
     *
     * @param id The ID of the material manufacturer to delete
     */
    void delete(int id);

    /**
     * Check if a material manufacturer exists by its ID
     *
     * @param id The ID of the material manufacturer to check
     * @return True if the material manufacturer exists, false otherwise
     */
    boolean existsById(int id);
}
