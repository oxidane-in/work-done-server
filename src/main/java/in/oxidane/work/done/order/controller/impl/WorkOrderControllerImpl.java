package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderController;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import in.oxidane.work.done.order.service.WorkOrderService;
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
public class WorkOrderControllerImpl implements WorkOrderController {

    private final WorkOrderService workOrderService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createWorkOrderRequestSchema;
    private String updateWorkOrderRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_REQUEST_SCHEMA).getInputStream()) {
            createWorkOrderRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_REQUEST_SCHEMA).getInputStream()) {
            updateWorkOrderRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderResponse> create(WorkOrderRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkOrderRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderResponse response = workOrderService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderResponse> update(Long id, WorkOrderRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkOrderRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderResponse response = workOrderService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderResponse> getById(Long id) {
        WorkOrderResponse response = workOrderService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderResponse> getByCode(String code) {
        WorkOrderResponse response = workOrderService.getByCode(code);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkOrderResponse>> getAll() {
        List<WorkOrderResponse> response = workOrderService.getAll();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        workOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
