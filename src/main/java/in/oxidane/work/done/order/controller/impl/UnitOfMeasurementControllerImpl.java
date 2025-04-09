package in.oxidane.work.done.order.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.order.controller.UnitOfMeasurementController;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.service.UnitOfMeasurementService;
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

/**
 * Implementation of the UnitOfMeasurementController interface.
 * Handles HTTP requests related to unit of measurement operations.
 */

@RestController
@RequiredArgsConstructor
public class UnitOfMeasurementControllerImpl implements UnitOfMeasurementController {

    private final UnitOfMeasurementService unitOfMeasurementService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;

    private String createUOMRequestSchema;
    private String updateUOMRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_UNIT_OF_MEASUREMENT_REQUEST_SCHEMA).getInputStream()) {
            createUOMRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_UNIT_OF_MEASUREMENT_REQUEST_SCHEMA).getInputStream()) {
            updateUOMRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> createUnitOfMeasurement(UnitOfMeasurementRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createUOMRequestSchema, objectMapper.writeValueAsString(request));
        UnitOfMeasurementResponse response = unitOfMeasurementService.createUnitOfMeasurement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> getUnitOfMeasurementById(Long id) {
        UnitOfMeasurementResponse response = unitOfMeasurementService.getUnitOfMeasurementById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<UnitOfMeasurementResponse>> getAllUnitsOfMeasurement() {
        List<UnitOfMeasurementResponse> response = unitOfMeasurementService.getAllUnitsOfMeasurement();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> updateUnitOfMeasurement(Long id, UnitOfMeasurementRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateUOMRequestSchema, objectMapper.writeValueAsString(request));
        unitOfMeasurementService.updateUnitOfMeasurement(id, request);
        return ResponseEntity.ok().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteUnitOfMeasurement(Long id) {
        unitOfMeasurementService.deleteUnitOfMeasurement(id);
        return ResponseEntity.noContent().build();
    }
}
