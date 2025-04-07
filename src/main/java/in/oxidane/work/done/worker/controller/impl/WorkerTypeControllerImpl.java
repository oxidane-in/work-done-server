package in.oxidane.work.done.worker.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.worker.controller.WorkerTypeController;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import in.oxidane.work.done.worker.dto.WorkerTypeResponse;
import in.oxidane.work.done.worker.service.WorkerTypeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Implementation of the WorkerTypeController interface.
 * Handles HTTP requests for worker type operations.
 */
@RestController
@RequiredArgsConstructor
public class WorkerTypeControllerImpl implements WorkerTypeController {

    private final WorkerTypeService workerTypeService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createWorkerTypeRequestSchema;
    private String updateWorkerTypeRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORKER_TYPE_REQUEST_SCHEMA).getInputStream()) {
            createWorkerTypeRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORKER_TYPE_REQUEST_SCHEMA).getInputStream()) {
            updateWorkerTypeRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkerTypeResponse> createWorkerType(WorkerTypeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkerTypeRequestSchema,objectMapper.writeValueAsString(request));
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
    public ResponseEntity<Void> updateWorkerType(Long id, WorkerTypeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkerTypeRequestSchema,objectMapper.writeValueAsString(request));
        workerTypeService.updateWorkerType(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteWorkerType(Long id) {
        workerTypeService.deleteWorkerType(id);
        return ResponseEntity.noContent().build();
    }
}
