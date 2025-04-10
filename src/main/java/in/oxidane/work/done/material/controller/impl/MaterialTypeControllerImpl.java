package in.oxidane.work.done.material.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.material.controller.MaterialTypeController;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.service.MaterialTypeService;
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
 * Implementation of the MaterialTypeController interface.
 * Provides REST API endpoints for managing material types.
 */
@RestController
@RequiredArgsConstructor
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createMaterialTypeControllerRequestSchema;
    private String updateMaterialTypeControllerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_MATERIAL_TYPE_REQUEST_SCHEMA).getInputStream()) {
            createMaterialTypeControllerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_MATERIAL_TYPE_REQUEST_SCHEMA).getInputStream()) {
            updateMaterialTypeControllerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> createMaterialType(MaterialTypeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createMaterialTypeControllerRequestSchema,objectMapper.writeValueAsString(request));
        MaterialTypeResponse response = materialTypeService.createMaterialType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> getMaterialTypeById(Long id) {
        MaterialTypeResponse response = materialTypeService.getMaterialTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialTypeResponse>> getAllMaterialTypes() {
        List<MaterialTypeResponse> responses = materialTypeService.getAllMaterialTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialType(Long id, MaterialTypeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateMaterialTypeControllerRequestSchema,objectMapper.writeValueAsString(request));
        materialTypeService.updateMaterialType(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialType(Long id) {
        materialTypeService.deleteMaterialType(id);
        return ResponseEntity.noContent().build();
    }
}
