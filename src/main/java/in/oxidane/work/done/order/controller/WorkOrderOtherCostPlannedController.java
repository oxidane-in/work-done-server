package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
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

@Tag(name = "WorkOrderOtherCostPlanned Management", description = "APIs for managing work_order_other_cost_planned")
@RequestMapping(Endpoints.WORK_ORDER_OTHER_COST_PLANNED_V1)
public interface WorkOrderOtherCostPlannedController {

    // Create
    @Operation(summary = "Create a new work_order_other_cost_planned")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "work_order_other_cost_planned created successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostPlanned.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderOtherCostPlannedResponse> createWorkOrderOtherCostPlanned(
        @RequestBody WorkOrderOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException;

    // Update
    @Operation(summary = "Update an existing work_order_other_cost_planned")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "work_order_other_cost_planned updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostPlanned.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_planned not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderOtherCostPlannedResponse> updateWorkOrderOtherCostPlanned(
        @Parameter(description = "WorkOrderOtherCostPlanned ID") @PathVariable Long id,
        @RequestBody WorkOrderOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException;

    // Get By Id
    @Operation(summary = "Get work_order_other_cost_planned by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "work_order_other_cost_planned found",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostPlannedResponse.class))),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_planned not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderOtherCostPlannedResponse> getWorkOrderOtherCostPlannedById(
        @Parameter(description = "work_order_other_cost_planned ID") @PathVariable Long id);

    // Get All
    @Operation(summary = "Get all work_order_other_cost_planned records")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of work_order_other_cost_planned retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostPlannedResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderOtherCostPlannedResponse>> getAllWorkOrderOtherCostPlanned();

    // Delete
    @Operation(summary = "Delete a work_order_other_cost_planned")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "work_order_other_cost_planned deleted successfully"),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_planned not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteWorkOrderOtherCostPlanned(
        @Parameter(description = "work_order_other_cost_planned ID") @PathVariable Long id);
}
