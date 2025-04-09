package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsRequest;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsResponse;
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

@Tag(name = "Work Order Line Items Management", description = "APIs for managing work order line items")
@RequestMapping(Endpoints.WORK_ORDER_LINE_ITEMS_V1)
public interface WorkOrderLineItemsController {

    @Operation(summary = "Create a new work order line item")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Line item created successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderLineItemsResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderLineItemsResponse> create(@RequestBody WorkOrderLineItemsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing work order line item")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Line item updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderLineItemsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Line item not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderLineItemsResponse> update(
        @Parameter(description = "Line Item ID") @PathVariable Long id,
        @RequestBody WorkOrderLineItemsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get work order line item by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Line item found",
            content = @Content(schema = @Schema(implementation = WorkOrderLineItemsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Line item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderLineItemsResponse> getById(@Parameter(description = "Line Item ID") @PathVariable Long id);

    @Operation(summary = "Get all work order line items")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of line items retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderLineItemsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderLineItemsResponse>> getAll();

    @Operation(summary = "Delete a work order line item")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Line item deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Line item not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "Line Item ID") @PathVariable Long id);
}
