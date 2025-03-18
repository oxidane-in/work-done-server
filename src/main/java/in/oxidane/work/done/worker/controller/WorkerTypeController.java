package in.oxidane.work.done.worker.controller;

import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
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

@Tag(name = "Worker Type", description = "Worker Type management APIs")
@RequestMapping("/api/v1/worker-types")
public interface WorkerTypeController {

    @Operation(summary = "Create a new worker type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Worker type created",
                    content = @Content(schema = @Schema(implementation = WorkerTypeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Worker type already exists")
    })
    @PostMapping
    ResponseEntity<WorkerTypeResponse> createWorkerType(
            @Parameter(description = "Worker type to create", required = true)
            @RequestBody WorkerTypeRequest request);

    @Operation(summary = "Get a worker type by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the worker type",
                    content = @Content(schema = @Schema(implementation = WorkerTypeResponse.class))),
            @ApiResponse(responseCode = "404", description = "Worker type not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkerTypeResponse> getWorkerTypeById(
            @Parameter(description = "ID of worker type to fetch", required = true)
            @PathVariable int id);

    @Operation(summary = "Get all worker types")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of worker types",
                    content = @Content(schema = @Schema(implementation = WorkerTypeResponse.class)))
    })
    @GetMapping
    ResponseEntity<List<WorkerTypeResponse>> getAllWorkerTypes();

    @Operation(summary = "Update a worker type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Worker type updated",
                    content = @Content(schema = @Schema(implementation = WorkerTypeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Worker type not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkerTypeResponse> updateWorkerType(
            @Parameter(description = "ID of worker type to update", required = true)
            @PathVariable int id,
            @Parameter(description = "Updated worker type details", required = true)
            @RequestBody WorkerTypeRequest request);

    @Operation(summary = "Delete a worker type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Worker type deleted"),
            @ApiResponse(responseCode = "404", description = "Worker type not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteWorkerType(
            @Parameter(description = "ID of worker type to delete", required = true)
            @PathVariable int id);
} 