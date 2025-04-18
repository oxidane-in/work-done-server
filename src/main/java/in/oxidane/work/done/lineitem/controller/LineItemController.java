package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
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

/**
 * REST API endpoints for LineItem operations.
 */
@Tag(name = "Line Items", description = "APIs for line item management")
@RequestMapping(Endpoints.LINE_ITEM_V1)
public interface LineItemController {

    /**
     * Creates a new line item.
     *
     * @param request The request containing line item details
     * @return The created line item
     */
    @Operation(
        summary = "Create a new line item",
        description = "Creates a new line item with the provided details",
        responses = {
            @ApiResponse(responseCode = "201", description = "Line item created successfully",
                content = @Content(schema = @Schema(implementation = LineItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Line item already exists")
        }
    )
    @PostMapping
    ResponseEntity<LineItemResponse> createLineItem(
        @Parameter(description = "Line item details", required = true)
        @RequestBody LineItemRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Retrieves a line item by its ID.
     *
     * @param id The ID of the line item to retrieve
     * @return The line item
     */
    @Operation(
        summary = "Get a line item by ID",
        description = "Retrieves a line item by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                content = @Content(schema = @Schema(implementation = LineItemResponse.class))),
            @ApiResponse(responseCode = "404", description = "Line item not found")
        }
    )
    @GetMapping("/{id}")
    ResponseEntity<LineItemResponse> getLineItemById(
        @Parameter(description = "Line item ID", required = true)
        @PathVariable("id") Long id
    );

    /**
     * Retrieves all line items.
     *
     * @return A list of all line items
     */
    @Operation(
        summary = "Get all line items",
        description = "Retrieves a list of all line items",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @GetMapping
    ResponseEntity<List<LineItemResponse>> getAllLineItems();

    /**
     * Updates an existing line item.
     *
     * @param id      The ID of the line item to update
     * @param request The request containing updated line item details
     * @return The updated line item
     */
    @Operation(
        summary = "Update a line item",
        description = "Updates an existing line item with the provided details",
        responses = {
            @ApiResponse(responseCode = "200", description = "Line item updated successfully",
                content = @Content(schema = @Schema(implementation = LineItemResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Line item not found")
        }
    )
    @PutMapping("/{id}")
    ResponseEntity<LineItemResponse> updateLineItem(
        @Parameter(description = "Line item ID", required = true)
        @PathVariable("id") Long id,
        @Parameter(description = "Updated line item details", required = true)
        @RequestBody LineItemRequest request
    ) throws JsonProcessingException, SchemaValidationException;

    /**
     * Deletes a line item by its ID.
     *
     * @param id The ID of the line item to delete
     * @return No content response
     */
    @Operation(
        summary = "Delete a line item",
        description = "Deletes a line item by its unique identifier",
        responses = {
            @ApiResponse(responseCode = "204", description = "Line item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Line item not found")
        }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteLineItem(
        @Parameter(description = "Line item ID", required = true)
        @PathVariable("id") Long id
    );
}
