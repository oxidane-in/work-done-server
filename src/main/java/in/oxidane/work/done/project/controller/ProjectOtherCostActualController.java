package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostActual;
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

@Tag(name = "ProjectOtherCostActual", description = "ProjectOtherCostActual management APIs")
@RequestMapping(Endpoints.PROJECT_OTHER_COST_ACTUAL_V1)
public interface ProjectOtherCostActualController {

    // create
    @Operation(summary = "Create a new project_other_cost_actual",
        description = "Creates a new project_other_cost_actual with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Project_other_cost_actual created successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostActual.class))),
        @ApiResponse(responseCode = "400", description = "Invalid request data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")

    })
    @PostMapping
    ResponseEntity<ProjectOtherCostActualResponse> createProjectOtherCostActual(
        @Parameter(description = "project_other_cost_actual details", required = true)
        @RequestBody ProjectOtherCostActualRequest request) throws JsonProcessingException, SchemaValidationException;

    // get by Id
    @Operation(summary = "Fetched project_other_cost_actual",
        description = "Fetched a project_other_cost_actual with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_actual fetched successfully"),
        @ApiResponse(responseCode = "404", description = "Project_other_cost_actual not found with given Id"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProjectOtherCostActualResponse>
    getOtherCostActualById(@Parameter(description = "Project_other_cost_actual ID", required = true) @PathVariable Long id);

    //get All
    @Operation(summary = "Fetched all project_other_cost_actual",
        description = "Fetched all project_other_cost_actual with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_actual fetched successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<ProjectOtherCostActualResponse>> getAllOtherCostActual();

    // update by Id
    @Operation(summary = "Update project_other_cost_actual",
        description = "Update a project_other_cost_actual with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_actual updated successfully",
            content = @Content(schema = @Schema(implementation = ProjectOtherCostActual.class))),
        @ApiResponse(responseCode = "404", description = "Project_other_cost_actual not found with given Id"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProjectOtherCostActualResponse> updateOtherCostActual(
        @Parameter(description = "project_other_cost_actual details", required = true) @PathVariable Long id,
        @RequestBody ProjectOtherCostActualRequest request) throws JsonProcessingException, SchemaValidationException;

    // delete by Id
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete project_other_cost_actual",
        description = "Delete  project_other_cost_actual with the provided details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Project_other_cost_actual fetched successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteOtherCostActual(@Parameter(description = "project_other_cost_actual details", required = true) @PathVariable Long id);
}
