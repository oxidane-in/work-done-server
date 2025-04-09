package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderMaterialDetailsController;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsResponse;
import in.oxidane.work.done.order.service.WorkOrderMaterialDetailsService;
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
public class WorkOrderMaterialDetailsControllerImpl implements WorkOrderMaterialDetailsController {

    private final WorkOrderMaterialDetailsService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createMaterialDetailRequestSchema;
    private String updateMaterialDetailRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_MATERIAL_DETAILS_REQUEST_SCHEMA).getInputStream()) {
            createMaterialDetailRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_MATERIAL_DETAILS_REQUEST_SCHEMA).getInputStream()) {
            updateMaterialDetailRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderMaterialDetailsResponse> create(WorkOrderMaterialDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createMaterialDetailRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderMaterialDetailsResponse response = service.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderMaterialDetailsResponse> update(Long id, WorkOrderMaterialDetailsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateMaterialDetailRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderMaterialDetailsResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderMaterialDetailsResponse> getById(Long id) {
        WorkOrderMaterialDetailsResponse response = service.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getByWorkOrderId(Long workOrderId) {
        List<WorkOrderMaterialDetailsResponse> responses = service.getByWorkOrderId(workOrderId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getByLineItemId(Long lineItemId) {
        List<WorkOrderMaterialDetailsResponse> responses = service.getByLineItemId(lineItemId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<List<WorkOrderMaterialDetailsResponse>> getAll() {
        List<WorkOrderMaterialDetailsResponse> responses = service.getAll();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
