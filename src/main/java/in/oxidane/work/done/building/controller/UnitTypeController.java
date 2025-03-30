package in.oxidane.work.done.building.controller;

import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API endpoints for UnitType operations.
 */
@Tag(name = "Unit Type", description = "APIs for unit type management")
@RequestMapping("/api/v1/unit-types")
public interface UnitTypeController {

    /**
     * Creates a new unit type.
     *
     * @param request The request containing unit type details
     * @return The created unit type
     */
    @Operation(
        summary = "Create a new unit type",
        description = "Creates a new unit type with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Unit type created successfully",
                content = @Content(schema = @Schema(implementation = UnitTypeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Unit type already exists")
        }
    )
    @PostMapping
    ResponseEntity<UnitTypeResponse> createUnitType(
        @Parameter(description = "Unit type details", required = true)
        @RequestBody UnitTypeRequest request
    );

    /**
     * Retrieves a unit type by its ID.
     *
     * @param id The ID of the unit type to retrieve
     * @return The unit type
     */
    @Operation(
        summary = "Get a unit type by ID",
        description = "Retrieves a unit type by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = UnitTypeResponse.class))),
            @ApiResponse(responseCode = "404", description = "Unit type not found")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<UnitTypeResponse> getUnitTypeById(
        @Parameter(description = "Unit type ID", required = true)
        @PathVariable("id") Long id
    );

    /**
     * Retrieves all unit types.
     *
     * @return A list of all unit types
     */
    @Operation(
        summary = "Get all unit types",
        description = "Retrieves a list of all unit types",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @GetMapping
    ResponseEntity<List<UnitTypeResponse>> getAllUnitTypes();

    /**
     * Updates an existing unit type.
     *
     * @param id The ID of the unit type to update
     * @param request The request containing updated unit type details
     * @return The updated unit type
     */
    @Operation(
        summary = "Update a unit type",
        description = "Updates an existing unit type with the provided details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Unit type updated successfully",
                content = @Content(schema = @Schema(implementation = UnitTypeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Unit type not found")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<UnitTypeResponse> updateUnitType(
        @Parameter(description = "Unit type ID", required = true)
        @PathVariable("id") Long id,
        @Parameter(description = "Updated unit type details", required = true)
        @RequestBody UnitTypeRequest request
    );

    /**
     * Deletes a unit type by its ID.
     *
     * @param id The ID of the unit type to delete
     * @return No content response
     */
    @Operation(
        summary = "Delete a unit type",
        description = "Deletes a unit type by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "204", description = "Unit type deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Unit type not found")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUnitType(
        @Parameter(description = "Unit type ID", required = true)
        @PathVariable("id") Long id
    );
}
