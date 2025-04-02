package in.oxidane.work.done.worker.controller.impl;

import in.oxidane.work.done.worker.controller.WorkerController;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import in.oxidane.work.done.worker.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class WorkerControllerImpl implements WorkerController {

    private final WorkerService workerService;

    @Override
    public ResponseEntity<WorkerResponse> createWorker(@RequestBody WorkerRequest request) {
        WorkerResponse createdWorker = workerService.createWorker(request);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkerResponse> getWorkerById(@PathVariable Long id) {
        WorkerResponse worker = workerService.getWorkerById(id);
        return ResponseEntity.ok(worker);
    }

    @Override
    public ResponseEntity<List<WorkerResponse>> getAllWorkers() {
        List<WorkerResponse> workers = workerService.getAllWorkers();
        return ResponseEntity.ok(workers);
    }

    @Override
    public ResponseEntity<WorkerResponse> updateWorker(@PathVariable Long id, @RequestBody WorkerRequest request) {
        WorkerResponse updatedWorker = workerService.updateWorker(id, request);
        return ResponseEntity.ok(updatedWorker);
    }

    @Override
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }
}
