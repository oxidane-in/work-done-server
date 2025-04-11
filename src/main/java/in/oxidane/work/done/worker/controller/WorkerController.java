package in.oxidane.work.done.worker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
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

@Tag(name = "Worker Management", description = "Worker management APIs")
@RequestMapping(Endpoints.WORKER_V1)
public interface WorkerController {

    @Operation(summary = "Create a new worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Worker created successfully",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    ResponseEntity<WorkerResponse> createWorker(@RequestBody WorkerRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get worker by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker found",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    ResponseEntity<WorkerResponse> getWorkerById(@Parameter(description = "Worker ID") @PathVariable Long id);

    @Operation(summary = "Get all workers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of workers retrieved",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<WorkerResponse>> getAllWorkers();

    @Operation(summary = "Update an existing worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Worker updated successfully",
            content = @Content(schema = @Schema(implementation = WorkerResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping("/{id}")
    ResponseEntity<WorkerResponse> updateWorker(
        @Parameter(description = "Worker ID") @PathVariable Long id,
        @RequestBody WorkerRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Delete a worker")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Worker deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Worker not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteWorker(@Parameter(description = "Worker ID") @PathVariable Long id);
}
