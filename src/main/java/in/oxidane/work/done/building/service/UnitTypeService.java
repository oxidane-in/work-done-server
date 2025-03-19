package in.oxidane.work.done.building.service;

import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;

import java.util.List;

/**
 * Service interface for UnitType operations.
 */
public interface UnitTypeService {

    /**
     * Creates a new unit type.
     *
     * @param request The request containing unit type details
     * @return The created unit type
     */
    UnitTypeResponse createUnitType(UnitTypeRequest request);

    /**
     * Retrieves a unit type by its ID.
     *
     * @param id The ID of the unit type to retrieve
     * @return The unit type
     */
    UnitTypeResponse getUnitTypeById(Integer id);

    /**
     * Retrieves all unit types.
     *
     * @return A list of all unit types
     */
    List<UnitTypeResponse> getAllUnitTypes();

    /**
     * Updates an existing unit type.
     *
     * @param id The ID of the unit type to update
     * @param request The request containing updated unit type details
     * @return The updated unit type
     */
    UnitTypeResponse updateUnitType(Integer id, UnitTypeRequest request);

    /**
     * Deletes a unit type by its ID.
     *
     * @param id The ID of the unit type to delete
     */
    void deleteUnitType(Integer id);
} 