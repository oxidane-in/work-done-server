package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
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
 * REST API endpoints for ProjectScope operations.
 */
@Tag(name = "Project Scope", description = "APIs for project scope management")
@RequestMapping(Endpoints.PROJECT_SCOPE_V1)
public interface ProjectScopeController {

    /**
     * Creates a new project scope.
     *
     * @param request The request containing project scope details
     * @return The created project scope
     */
    @Operation(
        summary = "Create a new project scope",
        description = "Creates a new project scope with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Project scope created successfully",
                content = @Content(schema = @Schema(implementation = ProjectScopeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Project scope already exists")
        }
    )
    @PostMapping
    ResponseEntity<ProjectScopeResponse> createProjectScope(
        @Parameter(description = "Project scope details", required = true)
        @RequestBody ProjectScopeRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Retrieves a project scope by its ID.
     *
     * @param id The ID of the project scope to retrieve
     * @return The project scope
     */
    @Operation(
        summary = "Get a project scope by ID",
        description = "Retrieves a project scope by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = ProjectScopeResponse.class))),
            @ApiResponse(responseCode = "404", description = "Project scope not found")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<ProjectScopeResponse> getProjectScopeById(
        @Parameter(description = "Project scope ID", required = true)
        @PathVariable("id") Long id
    );

    /**
     * Retrieves all project scopes.
     *
     * @return A list of all project scopes
     */
    @Operation(
        summary = "Get all project scopes",
        description = "Retrieves a list of all project scopes",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @GetMapping
    ResponseEntity<List<ProjectScopeResponse>> getAllProjectScopes();

    /**
     * Updates an existing project scope.
     *
     * @param id      The ID of the project scope to update
     * @param request The request containing updated project scope details
     * @return The updated project scope
     */
    @Operation(
        summary = "Update a project scope",
        description = "Updates an existing project scope with the provided details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Project scope updated successfully",
                content = @Content(schema = @Schema(implementation = ProjectScopeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Project scope not found")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<Void> updateProjectScope(
        @Parameter(description = "Project scope ID", required = true)
        @PathVariable("id") Long id,
        @Parameter(description = "Updated project scope details", required = true)
        @RequestBody ProjectScopeRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Deletes a project scope by its ID.
     *
     * @param id The ID of the project scope to delete
     * @return No content response
     */
    @Operation(
        summary = "Delete a project scope",
        description = "Deletes a project scope by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "204", description = "Project scope deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Project scope not found")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProjectScope(
        @Parameter(description = "Project scope ID", required = true)
        @PathVariable("id") Long id
    );
}
