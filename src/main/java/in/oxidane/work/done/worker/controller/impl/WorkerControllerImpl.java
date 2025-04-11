package in.oxidane.work.done.worker.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.worker.controller.WorkerController;
import in.oxidane.work.done.worker.dto.WorkerRequest;
import in.oxidane.work.done.worker.dto.WorkerResponse;
import in.oxidane.work.done.worker.service.WorkerService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WorkerControllerImpl implements WorkerController {

    private final WorkerService workerService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createWorkerRequestSchema;
    private String updateWorkerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORKER_REQUEST_SCHEMA).getInputStream()) {
            createWorkerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORKER_REQUEST_SCHEMA).getInputStream()) {
            updateWorkerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkerResponse> createWorker(WorkerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkerRequestSchema, objectMapper.writeValueAsString(request));
        WorkerResponse createdWorker = workerService.createWorker(request);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkerResponse> getWorkerById(Long id) {
        WorkerResponse worker = workerService.getWorkerById(id);
        return ResponseEntity.ok(worker);
    }

    @Override
    public ResponseEntity<List<WorkerResponse>> getAllWorkers() {
        List<WorkerResponse> workers = workerService.getAllWorkers();
        return ResponseEntity.ok(workers);
    }

    @Override
    public ResponseEntity<WorkerResponse> updateWorker(Long id, WorkerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkerRequestSchema, objectMapper.writeValueAsString(request));
        WorkerResponse updatedWorker = workerService.updateWorker(id, request);
        return ResponseEntity.ok(updatedWorker);
    }

    @Override
    public ResponseEntity<Void> deleteWorker(Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }
}
