package in.oxidane.work.done.project.controller;

import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
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
 * REST API endpoints for ProjectScope operations.
 */
@Tag(name = "Project Scope", description = "APIs for project scope management")
@RequestMapping("/api/v1/project-scopes")
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
    );

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
        @PathVariable("id") Integer id
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
     * @param id The ID of the project scope to update
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
    ResponseEntity<ProjectScopeResponse> updateProjectScope(
        @Parameter(description = "Project scope ID", required = true)
        @PathVariable("id") Integer id,
        @Parameter(description = "Updated project scope details", required = true)
        @RequestBody ProjectScopeRequest request
    );

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
        @PathVariable("id") Integer id
    );
}
