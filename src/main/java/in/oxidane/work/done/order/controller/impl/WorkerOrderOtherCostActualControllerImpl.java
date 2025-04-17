package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderOtherCostActualController;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualResponse;
import in.oxidane.work.done.order.service.impl.WorkOrderOtherCostActualServiceImpl;
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
public class WorkerOrderOtherCostActualControllerImpl implements WorkOrderOtherCostActualController {

    private final WorkOrderOtherCostActualServiceImpl workOrderOtherCostActualService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createWorkOrderOtherCostActualSchema;
    private String updateWorkOrderOtherCostActualSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_OTHER_COST_ACTUAL_SCHEMA).getInputStream()) {
            createWorkOrderOtherCostActualSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_OTHER_COST_ACTUAL_SCHEMA).getInputStream()) {
            updateWorkOrderOtherCostActualSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostActualResponse> createWorkOrderCostActual(WorkOrderOtherCostActualRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkOrderOtherCostActualSchema, objectMapper.writeValueAsString(request));
        WorkOrderOtherCostActualResponse response = workOrderOtherCostActualService.createWorkOrderCostActual(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostActualResponse> updateWorkOrderCostActualById(Long id, WorkOrderOtherCostActualRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkOrderOtherCostActualSchema, objectMapper.writeValueAsString(request));
        WorkOrderOtherCostActualResponse response = workOrderOtherCostActualService.updateWorkOrderCostActualById(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostActualResponse> getWorkOrderCostActualById(Long id) {
        WorkOrderOtherCostActualResponse response = workOrderOtherCostActualService.getWorkOrderCostActualById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkOrderOtherCostActualResponse>> getAllWorkOrderCostActual() {
        List<WorkOrderOtherCostActualResponse> responses = workOrderOtherCostActualService.getAllWorkOrderCostActual();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> deleteWorkOrderCostActual(Long id) {
        workOrderOtherCostActualService.deleteWorkOrderCostActual(id);
        return ResponseEntity.noContent().build();
    }
}
