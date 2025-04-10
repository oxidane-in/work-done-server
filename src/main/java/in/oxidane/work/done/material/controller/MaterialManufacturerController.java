package in.oxidane.work.done.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
 * Controller interface for MaterialManufacturer API endpoints.
 * Defines REST operations for managing material manufacturers.
 */
@Tag(name = "Material Manufacturer", description = "Material Manufacturer management APIs")
@RequestMapping(Endpoints.MATERIAL_MANUFACTURER_V1)
public interface MaterialManufacturerController {

    /**
     * Create a new material manufacturer
     *
     * @param request The MaterialManufacturerRequest containing manufacturer information
     * @return ResponseEntity with created MaterialManufacturerResponse and HTTP 201 status
     */
    @PostMapping
    @Operation(summary = "Create a new material manufacturer", description = "Creates a new material manufacturer in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Material manufacturer created successfully",
            content = @Content(schema = @Schema(implementation = MaterialManufacturerResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<MaterialManufacturerResponse> createMaterialManufacturer(@RequestBody MaterialManufacturerRequest request) throws JsonProcessingException, SchemaValidationException;

    /**
     * Get a material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to retrieve
     * @return ResponseEntity with MaterialManufacturerResponse if found, or HTTP 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get material manufacturer by ID", description = "Retrieves a material manufacturer by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material manufacturer found",
            content = @Content(schema = @Schema(implementation = MaterialManufacturerResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material manufacturer not found")
    })
    ResponseEntity<MaterialManufacturerResponse> getMaterialManufacturerById(
        @Parameter(description = "Material manufacturer ID", required = true) @PathVariable Long id);

    /**
     * Get all material manufacturers
     *
     * @return ResponseEntity with list of all MaterialManufacturerResponse objects
     */
    @GetMapping
    @Operation(summary = "Get all material manufacturers", description = "Retrieves a list of all material manufacturers")
    @ApiResponse(responseCode = "200", description = "List of material manufacturers retrieved successfully")
    ResponseEntity<List<MaterialManufacturerResponse>> getAllMaterialManufacturers();

    /**
     * Update a material manufacturer by ID
     *
     * @param id      The ID of the material manufacturer to update
     * @param request The MaterialManufacturerRequest containing updated information
     * @return ResponseEntity with updated MaterialManufacturerResponse if found, or HTTP 404
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a material manufacturer", description = "Updates an existing material manufacturer by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material manufacturer updated successfully",
            content = @Content(schema = @Schema(implementation = MaterialManufacturerResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material manufacturer not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<Void> updateMaterialManufacturer(
        @Parameter(description = "Material manufacturer ID", required = true) @PathVariable Long id,
        @RequestBody MaterialManufacturerRequest request) throws JsonProcessingException, SchemaValidationException;

    /**
     * Delete a material manufacturer by ID
     *
     * @param id The ID of the material manufacturer to delete
     * @return ResponseEntity with HTTP 204 if deleted, or HTTP 404
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a material manufacturer", description = "Deletes a material manufacturer by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Material manufacturer deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Material manufacturer not found")
    })
    ResponseEntity<Void> deleteMaterialManufacturer(
        @Parameter(description = "Material manufacturer ID", required = true) @PathVariable Long id);
}
