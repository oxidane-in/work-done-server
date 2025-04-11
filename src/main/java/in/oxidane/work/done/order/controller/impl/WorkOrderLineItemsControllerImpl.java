package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderLineItemsController;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsRequest;
import in.oxidane.work.done.order.dto.WorkOrderLineItemsResponse;
import in.oxidane.work.done.order.service.WorkOrderLineItemsService;
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
public class WorkOrderLineItemsControllerImpl implements WorkOrderLineItemsController {

    private final WorkOrderLineItemsService workOrderLineItemsService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createLineItemRequestSchema;
    private String updateLineItemRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_LINE_ITEMS_REQUEST_SCHEMA).getInputStream()) {
            createLineItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_LINE_ITEMS_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderLineItemsResponse> create(WorkOrderLineItemsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderLineItemsResponse response = workOrderLineItemsService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderLineItemsResponse> update(Long id, WorkOrderLineItemsRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemRequestSchema, objectMapper.writeValueAsString(request));
        WorkOrderLineItemsResponse response = workOrderLineItemsService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderLineItemsResponse> getById(Long id) {
        return ResponseEntity.ok(workOrderLineItemsService.getById(id));
    }

    @Override
    public ResponseEntity<List<WorkOrderLineItemsResponse>> getAll() {
        return ResponseEntity.ok(workOrderLineItemsService.getAll());
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        workOrderLineItemsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
