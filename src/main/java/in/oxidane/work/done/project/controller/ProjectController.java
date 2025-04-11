package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
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

@Tag(name = "Project", description = "Project management APIs")
@RequestMapping(Endpoints.PROJECT_V1)
public interface ProjectController {

    @Operation(
        summary = "Create a new project",
        description = "Creates a new project with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Project created successfully",
                content = @Content(schema = @Schema(implementation = ProjectResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    ResponseEntity<ProjectResponse> createProject(
        @Parameter(description = "Project details", required = true)
        @RequestBody ProjectRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(
        summary = "Get project by ID",
        description = "Retrieves a project by its ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Project found",
                content = @Content(schema = @Schema(implementation = ProjectResponse.class))),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<ProjectResponse> getProjectById(
        @Parameter(description = "Project ID", required = true) @PathVariable Long id);

    @Operation(
        summary = "Get all projects",
        description = "Retrieves a list of all projects",
        responses = {
            @ApiResponse(responseCode = "200", description = "List of projects",
                content = @Content(schema = @Schema(implementation = ProjectResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    ResponseEntity<List<ProjectResponse>> getAllProjects();

    @Operation(
        summary = "Update project",
        description = "Updates an existing project",
        responses = {
            @ApiResponse(responseCode = "200", description = "Project updated successfully",
                content = @Content(schema = @Schema(implementation = ProjectResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<ProjectResponse> updateProject(
        @Parameter(description = "Project ID", required = true) @PathVariable Long id,
        @Parameter(description = "Updated project details", required = true)
        @RequestBody ProjectRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(
        summary = "Delete project",
        description = "Deletes a project by its ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Project deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Project not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProject(
        @Parameter(description = "Project ID", required = true) @PathVariable Long id);
}
