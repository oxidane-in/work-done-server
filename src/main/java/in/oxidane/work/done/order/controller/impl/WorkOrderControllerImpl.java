package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderController;
import in.oxidane.work.done.order.dto.WorkOrderRequest;
import in.oxidane.work.done.order.dto.WorkOrderResponse;
import in.oxidane.work.done.order.service.WorkOrderService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(Endpoints.WORK_ORDER_V1)
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
    @PostMapping
    public ResponseEntity<WorkOrderResponse> create(@Valid @RequestBody WorkOrderRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkOrderRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderResponse response = workOrderService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<WorkOrderResponse> update(@PathVariable Long id, @Valid @RequestBody WorkOrderRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkOrderRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderResponse response = workOrderService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderResponse> getById(@PathVariable Long id) {
        WorkOrderResponse response = workOrderService.getById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/code/{code}")
    public ResponseEntity<WorkOrderResponse> getByCode(@PathVariable String code) {
        WorkOrderResponse response = workOrderService.getByCode(code);
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<WorkOrderResponse>> getAll() {
        List<WorkOrderResponse> response = workOrderService.getAll();
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        workOrderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
