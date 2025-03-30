package in.oxidane.work.done.worker.controller;

import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Worker Management", description = "Worker management APIs")
public interface WorkerController {

    @Operation(summary = "Create a new worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Worker created successfully",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<WorkerResponse> createWorker(@Valid @RequestBody WorkerRequest request);

    @Operation(summary = "Get worker by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker found",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<WorkerResponse> getWorkerById(@Parameter(description = "Worker ID") @PathVariable Long id);

    @Operation(summary = "Get all workers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of workers retrieved",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<List<WorkerResponse>> getAllWorkers();

    @Operation(summary = "Update an existing worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker updated successfully",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<WorkerResponse> updateWorker(
        @Parameter(description = "Worker ID") @PathVariable Long id,
        @Valid @RequestBody WorkerRequest request);

    @Operation(summary = "Delete a worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Worker deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteWorker(@Parameter(description = "Worker ID") @PathVariable Long id);
}
