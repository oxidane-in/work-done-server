package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * REST API endpoints for UnitOfMeasurement operations.
 */
@Tag(name = "Unit of Measurement", description = "APIs for unit of measurement management")
@RequestMapping(Endpoints.UNIT_OF_MEASUREMENT_V1)
public interface UnitOfMeasurementController {

    /**
     * Creates a new unit of measurement.
     *
     * @param request The request containing unit of measurement details
     * @return The created unit of measurement
     */
    @Operation(
        summary = "Create a new unit of measurement",
        description = "Creates a new unit of measurement with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Unit of measurement created successfully",
                content = @Content(schema = @Schema(implementation = UnitOfMeasurementResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Unit of measurement already exists")
        }
    )
    @PostMapping
    ResponseEntity<UnitOfMeasurementResponse> createUnitOfMeasurement(
        @Parameter(description = "Unit of measurement details", required = true)
        @RequestBody UnitOfMeasurementRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Retrieves a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to retrieve
     * @return The unit of measurement
     */
    @Operation(
        summary = "Get a unit of measurement by ID",
        description = "Retrieves a unit of measurement by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = UnitOfMeasurementResponse.class))),
            @ApiResponse(responseCode = "404", description = "Unit of measurement not found")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<UnitOfMeasurementResponse> getUnitOfMeasurementById(
        @Parameter(description = "Unit of measurement ID", required = true)
        @PathVariable("id") Long id
    );

    /**
     * Retrieves all units of measurement.
     *
     * @return A list of all units of measurement
     */
    @Operation(
        summary = "Get all units of measurement",
        description = "Retrieves a list of all units of measurement",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @GetMapping
    ResponseEntity<List<UnitOfMeasurementResponse>> getAllUnitsOfMeasurement();

    /**
     * Updates an existing unit of measurement.
     *
     * @param id      The ID of the unit of measurement to update
     * @param request The request containing updated unit of measurement details
     * @return The updated unit of measurement
     */
    @Operation(
        summary = "Update a unit of measurement",
        description = "Updates an existing unit of measurement with the provided details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Unit of measurement updated successfully",
                content = @Content(schema = @Schema(implementation = UnitOfMeasurementResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Unit of measurement not found")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<Void> updateUnitOfMeasurement(
        @Parameter(description = "Unit of measurement ID", required = true)
        @PathVariable("id") Long id,
        @Parameter(description = "Updated unit of measurement details", required = true)
        @RequestBody UnitOfMeasurementRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Deletes a unit of measurement by its ID.
     *
     * @param id The ID of the unit of measurement to delete
     * @return No content response
     */
    @Operation(
        summary = "Delete a unit of measurement",
        description = "Deletes a unit of measurement by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "204", description = "Unit of measurement deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Unit of measurement not found")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUnitOfMeasurement(
        @Parameter(description = "Unit of measurement ID", required = true)
        @PathVariable("id") Long id
    );
}
