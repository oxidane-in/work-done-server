package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ProjectOtherCostPlanned", description = "ProjectOtherCostPlanned management APIs")
@RequestMapping(Endpoints.PROJECT_OTHER_COST_PLANNED_V1)
public interface ProjectOtherCostPlannedController {

    // Create
    @Operation(summary = "Create a new project_other_cost_planned",
        description = "Creates a new project_other_cost_planned with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Project_other_cost_planned created successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostPlanned.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<ProjectOtherCostPlannedResponse> createProjectOtherCostPlanned(
        @Parameter(description = "project_other_cost_planned details", required = true)
        @RequestBody ProjectOtherCostPlannedRequest request) throws JsonProcessingException, SchemaValidationException;

    // Get by Id
    @Operation(summary = "Get project_other_cost_planned by ID",
        description = "Retrieves a project_other_cost_planned by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_planned found successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostPlannedResponse.class))),
        @ApiResponse(responseCode = "404", description = "Project_other_cost_planned not found with given ID"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProjectOtherCostPlannedResponse> getOtherCostPlannedById(
        @Parameter(description = "Project_other_cost_planned ID", required = true) @PathVariable Long id);

    // Get All
    @Operation(summary = "Get all project_other_cost_planned",
        description = "Retrieves all project_other_cost_planned records")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_planned records fetched successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostPlannedResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<ProjectOtherCostPlannedResponse>> getAllOtherCostPlanned();

    // Update by Id
    @Operation(summary = "Update project_other_cost_planned",
        description = "Updates an existing project_other_cost_planned with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_planned updated successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostPlanned.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "404", description = "Project_other_cost_planned not found with given ID"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProjectOtherCostPlannedResponse> updateOtherCostPlanned(
        @Parameter(description = "Project_other_cost_planned ID", required = true) @PathVariable Long id,
        @Parameter(description = "Updated project_other_cost_planned details", required = true)
        @RequestBody ProjectOtherCostPlannedRequest request) throws JsonProcessingException, SchemaValidationException;

    // Delete by Id
    @Operation(summary = "Delete project_other_cost_planned",
        description = "Deletes a project_other_cost_planned by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Project_other_cost_planned deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Project_other_cost_planned not found with given ID"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOtherCostPlanned(
        @Parameter(description = "Project_other_cost_planned ID", required = true) @PathVariable Long id);
}
