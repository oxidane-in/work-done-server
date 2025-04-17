package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.WorkOrderOtherCostPlannedController;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostPlannedResponse;
import in.oxidane.work.done.order.service.impl.WorkOrderOtherCostPlannedServiceImpl;
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
public class WorkOrderOtherPlannedControllerImpl implements WorkOrderOtherCostPlannedController {

    private final WorkOrderOtherCostPlannedServiceImpl workOrderOtherCostPlannedService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createWorkOrderOtherCostPlannedSchema;
    private String updateWorkOrderOtherCostPlannedSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_WORK_ORDER_OTHER_COST_PLANNED_SCHEMA).getInputStream()) {
            createWorkOrderOtherCostPlannedSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_WORK_ORDER_OTHER_COST_PLANNED_SCHEMA).getInputStream()) {
            updateWorkOrderOtherCostPlannedSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostPlannedResponse> createWorkOrderOtherCostPlanned(WorkOrderOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createWorkOrderOtherCostPlannedSchema, objectMapper.writeValueAsString(request));
        WorkOrderOtherCostPlannedResponse response = workOrderOtherCostPlannedService.createWorkOrderOtherCostPlanned(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostPlannedResponse> updateWorkOrderOtherCostPlanned(Long id, WorkOrderOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateWorkOrderOtherCostPlannedSchema, objectMapper.writeValueAsString(request));

        WorkOrderOtherCostPlannedResponse response = workOrderOtherCostPlannedService.updateWorkOrderOtherCostPlannedById(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<WorkOrderOtherCostPlannedResponse> getWorkOrderOtherCostPlannedById(Long id) {
        WorkOrderOtherCostPlannedResponse response = workOrderOtherCostPlannedService.getWorkOrderOtherCostPlannedById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<WorkOrderOtherCostPlannedResponse>> getAllWorkOrderOtherCostPlanned() {
        List<WorkOrderOtherCostPlannedResponse> responses = workOrderOtherCostPlannedService.getAllWorkOrderOtherCostPlannedById();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> deleteWorkOrderOtherCostPlanned(Long id) {
        workOrderOtherCostPlannedService.deleteWorkOrderOtherCostPlannedById(id);
        return ResponseEntity.noContent().build();
    }
}
