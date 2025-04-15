package in.oxidane.work.done.shared.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.shared.dto.OtherCostItemRequest;
import in.oxidane.work.done.shared.dto.OtherCostItemResponse;
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

@Tag(name = "OtherCostItem Management", description = "OtherCostItem Management Apis")
@RequestMapping(Endpoints.OTHER_COST_ITEM_V1)
public interface OtherCostItemController {

    // Controller for CRUD
    @Operation(summary = "Creating a new OtherCostItem")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "OtherCostItem created successfully",
            content = @Content(schema = @Schema(implementation = OtherCostItemResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<OtherCostItemResponse> createOtherCostItem(@RequestBody OtherCostItemRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get OtherCostItem by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OtherCostItem Found",
        content = @Content( schema = @Schema(implementation = OtherCostItemResponse.class))),
        @ApiResponse(responseCode = "404", description = "OtherCostItem Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<OtherCostItemResponse> getOtherCostItemById(@Parameter(description = "OtherCostItem_ID") @PathVariable Long id);

    @Operation(summary = "Get all OtherCostItem")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Fetched all OtherCostItem",
            content = @Content( schema = @Schema(implementation = OtherCostItemResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<OtherCostItemResponse>> getAllOtherCostItems();

    @Operation(summary = "Update existing OtherCostItem")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Updated OtherCostItem",
        content = @Content(schema = @Schema(implementation = OtherCostItemResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "OtherCostItem Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<OtherCostItemResponse> updateOtherCostItem(
        @Parameter(description = "OTHER_COST_ITEM_ID") @PathVariable Long id,
        @RequestBody  OtherCostItemRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Delete a OtherCostItem")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Deleted OtherCostItem"),
        @ApiResponse(responseCode = "404", description = "OtherCostItem Not Found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOtherCostItem(@Parameter(description = "OTHER_ITEM_COST_ID") @PathVariable Long id);
}
