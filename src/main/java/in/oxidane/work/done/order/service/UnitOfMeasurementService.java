package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;

import java.util.List;

/**
 * Service interface for UnitOfMeasurement operations.
 */
public interface UnitOfMeasurementService {

    /**
     * Creates a new unit of measurement.
     *
     * @param request The request containing unit of measurement details
     * @return The created unit of measurement
     */
    UnitOfMeasurementResponse createUnitOfMeasurement(UnitOfMeasurementRequest request);

    /**
     * Retrieves a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to retrieve
     * @return The unit of measurement
     */
    UnitOfMeasurementResponse getUnitOfMeasurementById(Integer id);

    /**
     * Retrieves all units of measurement.
     *
     * @return A list of all units of measurement
     */
    List<UnitOfMeasurementResponse> getAllUnitsOfMeasurement();

    /**
     * Updates an existing unit of measurement.
     *
     * @param id The ID of the unit of measurement to update
     * @param request The request containing updated unit of measurement details
     * @return The updated unit of measurement
     */
    UnitOfMeasurementResponse updateUnitOfMeasurement(Integer id, UnitOfMeasurementRequest request);

    /**
     * Deletes a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to delete
     */
    void deleteUnitOfMeasurement(Integer id);
} 