package in.oxidane.work.done.order.controller;

import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.exception.SchemaValidationException;

import java.util.List;

@Tag(name = "Work Order Management", description = "APIs for managing work orders")
@RequestMapping(Endpoints.WORK_ORDER_V1)
public interface WorkOrderController {

    @Operation(summary = "Create a new work order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Work order created successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderResponse> create(@Valid @RequestBody WorkOrderRequest request) 
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing work order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Work order updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Work order not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderResponse> update(
        @Parameter(description = "Work Order ID") @PathVariable Long id,
        @Valid @RequestBody WorkOrderRequest request) 
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get work order by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Work order found",
            content = @Content(schema = @Schema(implementation = WorkOrderResponse.class))),
        @ApiResponse(responseCode = "404", description = "Work order not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderResponse> getById(@Parameter(description = "Work Order ID") @PathVariable Long id);

    @Operation(summary = "Get work order by code")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Work order found",
            content = @Content(schema = @Schema(implementation = WorkOrderResponse.class))),
        @ApiResponse(responseCode = "404", description = "Work order not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/code/{code}")
    ResponseEntity<WorkOrderResponse> getByCode(@Parameter(description = "Work Order Code") @PathVariable String code);

    @Operation(summary = "Get all work orders")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of work orders retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderResponse>> getAll();

    @Operation(summary = "Delete a work order")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Work order deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Work order not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "Work Order ID") @PathVariable Long id);
} 