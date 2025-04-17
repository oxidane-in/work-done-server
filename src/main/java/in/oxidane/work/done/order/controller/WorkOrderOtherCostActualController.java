package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;
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

@Tag(name = "WorkOrderOtherCostActual Management", description = "APIs for managing work_order_other_cost_actual")
@RequestMapping(Endpoints.WORK_ORDER_OTHER_COST_ACTUAL_V1)
public interface WorkOrderOtherCostActualController {

    // create
    @Operation(summary = "Create a new work_order_other_cost_actual")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "work_order_other_cost_actual successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostActual.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderOtherCostActualResponse> createWorkOrderCostActual(
        @RequestBody WorkOrderOtherCostActualRequest request)
        throws JsonProcessingException, SchemaValidationException;

    // update
    @Operation(summary = "Update an existing work_order_other_cost_actual")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "work_order_other_cost_actual updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostActual.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_actual not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderOtherCostActualResponse> updateWorkOrderCostActualById(
        @Parameter(description = "WorkOrderOtherCostActual ID") @PathVariable Long id,
        @RequestBody WorkOrderOtherCostActualRequest request)
        throws JsonProcessingException, SchemaValidationException;

    // Get By Id
    @Operation(summary = "Get work_order_other_cost_actual by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "work_order_other_cost_actual found"),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_actual not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderOtherCostActualResponse> getWorkOrderCostActualById(
        @Parameter(description = "work_order_other_cost_actual ID") @PathVariable Long id);

    // Get All
    @Operation(summary = "Get all work_order_other_cost_actual actual")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of work_order_other_cost_actual retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderOtherCostActualResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderOtherCostActualResponse>> getAllWorkOrderCostActual();

    // Delete
    @Operation(summary = "Delete a work_order_other_cost_actual")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "work_order_other_cost_actual deleted successfully"),
        @ApiResponse(responseCode = "404", description = "work_order_other_cost_actual not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteWorkOrderCostActual(
        @Parameter(description = "work_order_other_cost_actual ID") @PathVariable Long id);
}
