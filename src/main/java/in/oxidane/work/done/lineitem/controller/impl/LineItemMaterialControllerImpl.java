package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemMaterialController;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialRequest;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialResponse;
import in.oxidane.work.done.lineitem.service.LineItemMaterialService;
import io.micrometer.core.instrument.util.IOUtils;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LineItemMaterialControllerImpl implements LineItemMaterialController {

    private final LineItemMaterialService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemMaterialRequestSchema;
    private String updateLineItemMaterialRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_MATERIAL_REQUEST_SCHEMA).getInputStream()) {
            createLineItemMaterialRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_MATERIAL_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemMaterialRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<LineItemMaterialResponse> create(LineItemMaterialRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemMaterialRequestSchema,objectMapper.writeValueAsString(request));
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LineItemMaterialResponse> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    public ResponseEntity<List<LineItemMaterialResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public ResponseEntity<LineItemMaterialResponse> update(Long id, LineItemMaterialRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemMaterialRequestSchema,objectMapper.writeValueAsString(request));
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
