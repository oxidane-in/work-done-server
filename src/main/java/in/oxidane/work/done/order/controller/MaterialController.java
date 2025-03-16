package in.oxidane.work.done.order.controller;

import in.oxidane.work.done.order.dto.MaterialRequest;
import in.oxidane.work.done.order.dto.MaterialResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API for Material operations.
 * Defines endpoints to manage materials.
 */
@Tag(name = "Material", description = "Material Management API")
@RequestMapping("/api/materials")
public interface MaterialController {

    /**
     * Creates a new material.
     *
     * @param request The material data for creation
     * @return The created material
     */
    @Operation(
            summary = "Create a new material",
            description = "Creates a new material with the provided data",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Material created successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input data"
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<MaterialResponse> createMaterial(
            @Valid @RequestBody MaterialRequest request
    );

    /**
     * Retrieves a material by its ID.
     *
     * @param materialId The ID of the material to retrieve
     * @return The material, if found
     */
    @Operation(
            summary = "Get a material by ID",
            description = "Retrieves a material by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Material found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Material not found"
                    )
            }
    )
    @GetMapping("/{materialId}")
    ResponseEntity<MaterialResponse> getMaterialById(
            @Parameter(description = "ID of the material to retrieve", required = true)
            @PathVariable Integer materialId
    );

    /**
     * Retrieves all materials.
     *
     * @return A list of all materials
     */
    @Operation(
            summary = "Get all materials",
            description = "Retrieves a list of all materials",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Materials retrieved successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class))
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<MaterialResponse>> getAllMaterials();

    /**
     * Updates an existing material.
     *
     * @param materialId The ID of the material to update
     * @param request The material data for update
     * @return The updated material
     */
    @Operation(
            summary = "Update a material",
            description = "Updates an existing material with the provided data",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Material updated successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = MaterialResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid input data"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Material not found"
                    )
            }
    )
    @PutMapping("/{materialId}")
    ResponseEntity<MaterialResponse> updateMaterial(
            @Parameter(description = "ID of the material to update", required = true)
            @PathVariable Integer materialId,
            @Valid @RequestBody MaterialRequest request
    );

    /**
     * Deletes a material by its ID.
     *
     * @param materialId The ID of the material to delete
     * @return No content if successful
     */
    @Operation(
            summary = "Delete a material",
            description = "Deletes a material by its ID",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Material deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Material not found"
                    )
            }
    )
    @DeleteMapping("/{materialId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteMaterial(
            @Parameter(description = "ID of the material to delete", required = true)
            @PathVariable Integer materialId
    );
} 