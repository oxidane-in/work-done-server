package in.oxidane.work.done.material.controller;

import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller interface for MaterialVendor API endpoints.
 * Defines REST operations for managing material vendors.
 */
@Tag(name = "Material Vendor", description = "Material Vendor management APIs")
public interface MaterialVendorController {

    /**
     * Create a new material vendor
     *
     * @param request The MaterialVendorRequest containing vendor information
     * @return ResponseEntity with created MaterialVendorResponse and HTTP 201 status
     */
    @PostMapping
    @Operation(summary = "Create a new material vendor", description = "Creates a new material vendor in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Material vendor created successfully",
                    content = @Content(schema = @Schema(implementation = MaterialVendorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<MaterialVendorResponse> createMaterialVendor(@Valid @RequestBody MaterialVendorRequest request);

    /**
     * Get a material vendor by ID
     *
     * @param id The ID of the material vendor to retrieve
     * @return ResponseEntity with MaterialVendorResponse if found, or HTTP 404
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get material vendor by ID", description = "Retrieves a material vendor by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material vendor found",
                    content = @Content(schema = @Schema(implementation = MaterialVendorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Material vendor not found")
    })
    ResponseEntity<MaterialVendorResponse> getMaterialVendorById(
            @Parameter(description = "Material vendor ID", required = true) @PathVariable int id);

    /**
     * Get all material vendors
     *
     * @return ResponseEntity with list of all MaterialVendorResponse objects
     */
    @GetMapping
    @Operation(summary = "Get all material vendors", description = "Retrieves a list of all material vendors")
    @ApiResponse(responseCode = "200", description = "List of material vendors retrieved successfully")
    ResponseEntity<List<MaterialVendorResponse>> getAllMaterialVendors();

    /**
     * Update a material vendor by ID
     *
     * @param id The ID of the material vendor to update
     * @param request The MaterialVendorRequest containing updated information
     * @return ResponseEntity with updated MaterialVendorResponse if found, or HTTP 404
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a material vendor", description = "Updates an existing material vendor by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Material vendor updated successfully",
                    content = @Content(schema = @Schema(implementation = MaterialVendorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Material vendor not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<MaterialVendorResponse> updateMaterialVendor(
            @Parameter(description = "Material vendor ID", required = true) @PathVariable int id,
            @Valid @RequestBody MaterialVendorRequest request);

    /**
     * Delete a material vendor by ID
     *
     * @param id The ID of the material vendor to delete
     * @return ResponseEntity with HTTP 204 if deleted, or HTTP 404
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a material vendor", description = "Deletes a material vendor by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Material vendor deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Material vendor not found")
    })
    ResponseEntity<Void> deleteMaterialVendor(
            @Parameter(description = "Material vendor ID", required = true) @PathVariable int id);
}
