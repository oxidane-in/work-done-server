package in.oxidane.work.done.worker.controller.impl;

import in.oxidane.work.done.worker.controller.WorkerTypeController;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.service.WorkerTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the WorkerTypeController interface.
 * Handles HTTP requests for worker type operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class WorkerTypeControllerImpl implements WorkerTypeController {

    private final WorkerTypeService workerTypeService;

    @Override
    public ResponseEntity<WorkerTypeResponse> createWorkerType(@Valid WorkerTypeRequest request) {
        log.debug("Controller - Creating worker type: {}", request.getWorkerTypeName());
        WorkerTypeResponse response = workerTypeService.createWorkerType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkerTypeResponse> getWorkerTypeById(int id) {
        log.debug("Controller - Fetching worker type with ID: {}", id);
        WorkerTypeResponse response = workerTypeService.getWorkerTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkerTypeResponse>> getAllWorkerTypes() {
        log.debug("Controller - Fetching all worker types");
        List<WorkerTypeResponse> responses = workerTypeService.getAllWorkerTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<WorkerTypeResponse> updateWorkerType(int id, @Valid WorkerTypeRequest request) {
        log.debug("Controller - Updating worker type with ID: {}", id);
        WorkerTypeResponse response = workerTypeService.updateWorkerType(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteWorkerType(int id) {
        log.debug("Controller - Deleting worker type with ID: {}", id);
        workerTypeService.deleteWorkerType(id);
        return ResponseEntity.noContent().build();
    }
} 