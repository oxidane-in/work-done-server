package in.oxidane.work.done.lineitem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerRequest;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

@Tag(name = "Line Item Worker", description = "Line Item Worker Management APIs")
@RequestMapping(Endpoints.LINE_ITEM_WORKER_V1)
public interface LineItemWorkerController {

    @Operation(summary = "Create a new line item worker")
    @ApiResponse(responseCode = "201", description = "Line item worker created successfully")
    @PostMapping
    ResponseEntity<LineItemWorkerResponse> create(@RequestBody LineItemWorkerRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get a line item worker by ID")
    @ApiResponse(responseCode = "200", description = "Line item worker found")
    @ApiResponse(responseCode = "404", description = "Line item worker not found")
    @GetMapping("/{id}")
    ResponseEntity<LineItemWorkerResponse> getById(
            @Parameter(description = "Line item worker ID") @PathVariable Long id);

    @Operation(summary = "Get all line item workers")
    @ApiResponse(responseCode = "200", description = "List of line item workers")
    @GetMapping
    ResponseEntity<List<LineItemWorkerResponse>> getAll();

    @Operation(summary = "Update a line item worker")
    @ApiResponse(responseCode = "200", description = "Line item worker updated successfully")
    @ApiResponse(responseCode = "404", description = "Line item worker not found")
    @PutMapping("/{id}")
    ResponseEntity<LineItemWorkerResponse> update(
            @Parameter(description = "Line item worker ID") @PathVariable Long id,
            @RequestBody LineItemWorkerRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Delete a line item worker")
    @ApiResponse(responseCode = "204", description = "Line item worker deleted successfully")
    @ApiResponse(responseCode = "404", description = "Line item worker not found")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(
            @Parameter(description = "Line item worker ID") @PathVariable Long id);
}
