package in.oxidane.work.done.material.controller;

import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller interface for MaterialType API endpoints.
 * Defines REST operations for managing material types.
 */
@Tag(name = "Material Type", description = "Material Type management APIs")
@Validated
@RequestMapping(Endpoints.MATERIAL_TYPE_V1)
public interface MaterialTypeController {

    /**
     * Create a new material type
     *
     * @param request The MaterialTypeRequest containing type information
     * @return ResponseEntity with created MaterialTypeResponse and HTTP 201 status
     */
    @PostMapping
    @Operation(summary = "Create a new material type", description = "Creates a new material type in the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Material type created successfully",
            content = @Content(schema = @Schema(implementation = MaterialTypeResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<MaterialTypeResponse> createMaterialType(@Valid @RequestBody MaterialTypeRequest request);

    /**
     * Get a material type by ID
     *
     * @param id The ID of the material type to retrieve
     * @return ResponseEntity with MaterialTypeResponse if found, or HTTP 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get material type by ID", description = "Retrieves a material type by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material type found",
            content = @Content(schema = @Schema(implementation = MaterialTypeResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material type not found")
    })
    ResponseEntity<MaterialTypeResponse> getMaterialTypeById(
        @Parameter(description = "Material type ID", required = true) @PathVariable Long id);

    /**
     * Get all material types
     *
     * @return ResponseEntity with list of all MaterialTypeResponse objects
     */
    @GetMapping
    @Operation(summary = "Get all material types", description = "Retrieves a list of all material types")
    @ApiResponse(responseCode = "200", description = "List of material types retrieved successfully")
    ResponseEntity<List<MaterialTypeResponse>> getAllMaterialTypes();

    /**
     * Update a material type by ID
     *
     * @param id      The ID of the material type to update
     * @param request The MaterialTypeRequest containing updated information
     * @return ResponseEntity with updated MaterialTypeResponse if found, or HTTP 404
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a material type", description = "Updates an existing material type by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material type updated successfully",
            content = @Content(schema = @Schema(implementation = MaterialTypeResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material type not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<Void> updateMaterialType(
        @Parameter(description = "Material type ID", required = true) @PathVariable Long id,
        @Valid @RequestBody MaterialTypeRequest request);

    /**
     * Delete a material type by ID
     *
     * @param id The ID of the material type to delete
     * @return ResponseEntity with HTTP 204 if deleted, or HTTP 404
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a material type", description = "Deletes a material type by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Material type deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Material type not found")
    })
    ResponseEntity<Void> deleteMaterialType(
        @Parameter(description = "Material type ID", required = true) @PathVariable Long id);
}
