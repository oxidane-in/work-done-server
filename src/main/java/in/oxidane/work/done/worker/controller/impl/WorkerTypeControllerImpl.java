package in.oxidane.work.done.worker.controller.impl;

import in.oxidane.work.done.worker.controller.WorkerTypeController;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.service.WorkerTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the WorkerTypeController interface.
 * Handles HTTP requests for worker type operations.
 */
@RestController
@RequiredArgsConstructor
public class WorkerTypeControllerImpl implements WorkerTypeController {

    private final WorkerTypeService workerTypeService;

    @Override
    public ResponseEntity<WorkerTypeResponse> createWorkerType(@Valid WorkerTypeRequest request) {
        WorkerTypeResponse response = workerTypeService.createWorkerType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkerTypeResponse> getWorkerTypeById(Long id) {
        WorkerTypeResponse response = workerTypeService.getWorkerTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkerTypeResponse>> getAllWorkerTypes() {
        List<WorkerTypeResponse> responses = workerTypeService.getAllWorkerTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateWorkerType(Long id, @Valid WorkerTypeRequest request) {
        workerTypeService.updateWorkerType(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteWorkerType(Long id) {
        workerTypeService.deleteWorkerType(id);
        return ResponseEntity.noContent().build();
    }
}
