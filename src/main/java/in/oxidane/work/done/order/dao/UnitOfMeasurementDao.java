package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.entity.UnitOfMeasurement;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for UnitOfMeasurement entity.
 * Provides methods to interact with the database for UnitOfMeasurement operations.
 */
public interface UnitOfMeasurementDao {
    
    /**
     * Retrieves a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to retrieve
     * @return An Optional containing the unit of measurement if found, or empty if not found
     */
    Optional<UnitOfMeasurement> getById(Integer id);
    
    /**
     * Retrieves all units of measurement.
     *
     * @return A list of all units of measurement
     */
    List<UnitOfMeasurement> getAll();
    
    /**
     * Creates a new unit of measurement.
     *
     * @param unitOfMeasurement The unit of measurement to create
     * @return The created unit of measurement with generated ID
     */
    UnitOfMeasurement create(UnitOfMeasurement unitOfMeasurement);
    
    /**
     * Updates an existing unit of measurement.
     *
     * @param unitOfMeasurement The unit of measurement to update
     * @return The updated unit of measurement
     */
    UnitOfMeasurement update(UnitOfMeasurement unitOfMeasurement);
    
    /**
     * Deletes a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to delete
     */
    void delete(Integer id);
    
    /**
     * Checks if a unit of measurement with the specified ID exists.
     *
     * @param id The ID to check
     * @return true if the unit of measurement exists, false otherwise
     */
    boolean existsById(Integer id);
    
    /**
     * Checks if a unit of measurement with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a unit of measurement with the handle exists, false otherwise
     */
    boolean existsByHandle(String handle);
    
    /**
     * Checks if a unit of measurement with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id The ID to exclude from the check
     * @return true if another unit of measurement with the handle exists, false otherwise
     */
    boolean existsByHandleAndIdNot(String handle, Integer id);
} 