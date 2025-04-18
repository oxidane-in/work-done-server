package in.oxidane.work.done.material.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
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
 * Controller interface for MaterialVendor API endpoints.
 * Defines REST operations for managing material vendors.
 */
@Tag(name = "Material Vendor", description = "Material Vendor management APIs")
@RequestMapping(Endpoints.MATERIAL_VENDOR_V1)
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
    ResponseEntity<MaterialVendorResponse> createMaterialVendor(@RequestBody MaterialVendorRequest request) throws JsonProcessingException, SchemaValidationException;

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
        @Parameter(description = "Material vendor ID", required = true) @PathVariable Long id);

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
     * @param id      The ID of the material vendor to update
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
    ResponseEntity<Void> updateMaterialVendor(
        @Parameter(description = "Material vendor ID", required = true) @PathVariable Long id,
        @RequestBody MaterialVendorRequest request) throws JsonProcessingException, SchemaValidationException;

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
        @Parameter(description = "Material vendor ID", required = true) @PathVariable Long id);
}
