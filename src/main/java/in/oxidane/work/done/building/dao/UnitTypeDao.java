package in.oxidane.work.done.building.dao;

import in.oxidane.work.done.building.entity.UnitType;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for UnitType entity.
 * Provides methods to interact with the database for UnitType operations.
 */
public interface UnitTypeDao {

    /**
     * Retrieves a unit type by its ID.
     *
     * @param id The ID of the unit type to retrieve
     * @return An Optional containing the unit type if found, or empty if not found
     */
    Optional<UnitType> getById(Long id);

    /**
     * Retrieves all unit types.
     *
     * @return A list of all unit types
     */
    List<UnitType> getAll();

    /**
     * Creates a new unit type.
     *
     * @param unitType The unit type to create
     * @return The created unit type with generated ID
     */
    UnitType create(UnitType unitType);

    /**
     * Updates an existing unit type.
     *
     * @param unitType The unit type to update
     * @return The updated unit type
     */
    UnitType update(UnitType unitType);

    /**
     * Deletes a unit type by its ID.
     *
     * @param id The ID of the unit type to delete
     */
    void delete(Long id);

    /**
     * Checks if a unit type with the specified ID exists.
     *
     * @param id The ID to check
     * @return true if the unit type exists, false otherwise
     */
    boolean existsById(Long id);

    /**
     * Checks if a unit type with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a unit type with the handle exists, false otherwise
     */
    boolean existsByHandle(String handle);

}
