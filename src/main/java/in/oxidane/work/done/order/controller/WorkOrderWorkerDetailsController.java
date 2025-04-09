package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Work Order Worker Details Management", description = "APIs for managing work order worker details")
@RequestMapping(Endpoints.WORK_ORDER_WORKER_DETAILS_V1)
public interface WorkOrderWorkerDetailsController {

    @Operation(summary = "Create a new work order worker detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Worker detail created successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderWorkerDetailsResponse> create(@Valid @RequestBody WorkOrderWorkerDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing work order worker detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker detail updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Worker detail not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderWorkerDetailsResponse> update(
        @Parameter(description = "Worker Detail ID") @PathVariable Long id,
        @Valid @RequestBody WorkOrderWorkerDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get work order worker detail by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker detail found",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Worker detail not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderWorkerDetailsResponse> getById(
        @Parameter(description = "Worker Detail ID") @PathVariable Long id);

    @Operation(summary = "Get worker details by work order ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker details found",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/work-order/{workOrderId}")
    ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByWorkOrderId(
        @Parameter(description = "Work Order ID") @PathVariable Long workOrderId);

    @Operation(summary = "Get worker details by line item ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker details found",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/line-item/{lineItemId}")
    ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByLineItemId(
        @Parameter(description = "Line Item ID") @PathVariable Long lineItemId);

    @Operation(summary = "Get worker details by worker type ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker details found",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/worker-type/{workerTypeId}")
    ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByWorkerTypeId(
        @Parameter(description = "Worker Type ID") @PathVariable Long workerTypeId);

    @Operation(summary = "Get all work order worker details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of worker details retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderWorkerDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getAll();

    @Operation(summary = "Delete a work order worker detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Worker detail deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Worker detail not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "Worker Detail ID") @PathVariable Long id);
}
