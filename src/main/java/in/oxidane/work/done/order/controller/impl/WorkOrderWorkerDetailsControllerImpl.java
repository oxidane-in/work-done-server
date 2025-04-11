package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderWorkerDetailsController;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderWorkerDetailsResponse;
import in.oxidane.work.done.order.service.WorkOrderWorkerDetailsService;
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
public class WorkOrderWorkerDetailsControllerImpl implements WorkOrderWorkerDetailsController {

    private final WorkOrderWorkerDetailsService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createWorkerDetailRequestSchema;
    private String updateWorkerDetailRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_WORKER_DETAILS_REQUEST_SCHEMA).getInputStream()) {
            createWorkerDetailRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_WORKER_DETAILS_REQUEST_SCHEMA).getInputStream()) {
            updateWorkerDetailRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderWorkerDetailsResponse> create(WorkOrderWorkerDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkerDetailRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderWorkerDetailsResponse response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderWorkerDetailsResponse> update(Long id, WorkOrderWorkerDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkerDetailRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderWorkerDetailsResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderWorkerDetailsResponse> getById(Long id) {
        WorkOrderWorkerDetailsResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByWorkOrderId(Long workOrderId) {
        List<WorkOrderWorkerDetailsResponse> responses = service.getByWorkOrderId(workOrderId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByLineItemId(Long lineItemId) {
        List<WorkOrderWorkerDetailsResponse> responses = service.getByLineItemId(lineItemId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getByWorkerTypeId(Long workerTypeId) {
        List<WorkOrderWorkerDetailsResponse> responses = service.getByWorkerTypeId(workerTypeId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<List<WorkOrderWorkerDetailsResponse>> getAll() {
        List<WorkOrderWorkerDetailsResponse> responses = service.getAll();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
