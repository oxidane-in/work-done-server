package in.oxidane.work.done.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsResponse;
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

@Tag(name = "Work Order Material Details Management", description = "APIs for managing work order material details")
@RequestMapping(Endpoints.WORK_ORDER_MATERIAL_DETAILS_V1)
public interface WorkOrderMaterialDetailsController {

    @Operation(summary = "Create a new work order material detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Material detail created successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkOrderMaterialDetailsResponse> create(@Valid @RequestBody WorkOrderMaterialDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Update an existing work order material detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material detail updated successfully",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material detail not found"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkOrderMaterialDetailsResponse> update(
        @Parameter(description = "Material Detail ID") @PathVariable Long id,
        @Valid @RequestBody WorkOrderMaterialDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get work order material detail by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material detail found",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "404", description = "Material detail not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkOrderMaterialDetailsResponse> getById(
        @Parameter(description = "Material Detail ID") @PathVariable Long id);

    @Operation(summary = "Get material details by work order ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material details found",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/work-order/{workOrderId}")
    ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getByWorkOrderId(
        @Parameter(description = "Work Order ID") @PathVariable Long workOrderId);

    @Operation(summary = "Get material details by line item ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Material details found",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/line-item/{lineItemId}")
    ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getByLineItemId(
        @Parameter(description = "Line Item ID") @PathVariable Long lineItemId);

    @Operation(summary = "Get all work order material details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of material details retrieved",
            content = @Content(schema = @Schema(implementation = WorkOrderMaterialDetailsResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getAll();

    @Operation(summary = "Delete a work order material detail")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Material detail deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Material detail not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@Parameter(description = "Material Detail ID") @PathVariable Long id);
}
