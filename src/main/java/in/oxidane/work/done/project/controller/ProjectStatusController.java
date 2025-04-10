package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
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
 * REST API endpoints for ProjectStatus operations.
 */
@Tag(name = "Project Status", description = "APIs for project status management")
@RequestMapping(Endpoints.PROJECT_STATUS_V1)
public interface ProjectStatusController {

    /**
     * Creates a new project status.
     *
     * @param request The request containing project status details
     * @return The created project status
     */
    @Operation(
        summary = "Create a new project status",
        description = "Creates a new project status with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Project status created successfully",
                content = @Content(schema = @Schema(implementation = ProjectStatusResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Project status already exists")
        }
    )
    @PostMapping
    ResponseEntity<ProjectStatusResponse> createProjectStatus(
        @Parameter(description = "Project status details", required = true)
        @RequestBody ProjectStatusRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Retrieves a project status by its ID.
     *
     * @param id The ID of the project status to retrieve
     * @return The project status
     */
    @Operation(
        summary = "Get a project status by ID",
        description = "Retrieves a project status by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ProjectStatusResponse.class))),
            @ApiResponse(responseCode = "404", description = "Project status not found")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<ProjectStatusResponse> getProjectStatusById(
        @Parameter(description = "Project status ID", required = true)
        @PathVariable("id") Long id
    );

    /**
     * Retrieves all project statuses.
     *
     * @return A list of all project statuses
     */
    @Operation(
        summary = "Get all project statuses",
        description = "Retrieves a list of all project statuses",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @GetMapping
    ResponseEntity<List<ProjectStatusResponse>> getAllProjectStatuses();

    /**
     * Updates an existing project status.
     *
     * @param id      The ID of the project status to update
     * @param request The request containing updated project status details
     * @return The updated project status
     */
    @Operation(
        summary = "Update a project status",
        description = "Updates an existing project status with the provided details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Project status updated successfully",
                content = @Content(schema = @Schema(implementation = ProjectStatusResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Project status not found")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<Void> updateProjectStatus(
        @Parameter(description = "Project status ID", required = true)
        @PathVariable("id") Long id,
        @Parameter(description = "Updated project status details", required = true)
        @RequestBody ProjectStatusRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Deletes a project status by its ID.
     *
     * @param id The ID of the project status to delete
     * @return No content response
     */
    @Operation(
        summary = "Delete a project status",
        description = "Deletes a project status by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "204", description = "Project status deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Project status not found")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProjectStatus(
        @Parameter(description = "Project status ID", required = true)
        @PathVariable("id") Long id
    );
}
