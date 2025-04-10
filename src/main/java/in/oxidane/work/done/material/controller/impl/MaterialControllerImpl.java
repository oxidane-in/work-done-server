package in.oxidane.work.done.material.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.material.controller.MaterialController;
import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.service.MaterialService;
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
 * Implementation of the MaterialController interface.
 * Provides REST endpoints for Material operations.
 */
@RestController
@RequiredArgsConstructor
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createMaterialControllerRequestSchema;
    private String updateMaterialControllerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_MATERIAL_REQUEST_SCHEMA).getInputStream()) {
            createMaterialControllerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_MATERIAL_REQUEST_SCHEMA).getInputStream()) {
            updateMaterialControllerRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<MaterialResponse> createMaterial(MaterialRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createMaterialControllerRequestSchema,objectMapper.writeValueAsString(request));
        MaterialResponse response = materialService.createMaterial(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<MaterialResponse> getMaterialById(Long materialId) {
        MaterialResponse response = materialService.getMaterialById(materialId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialResponse>> getAllMaterials() {
        List<MaterialResponse> materials = materialService.getAllMaterials();
        return ResponseEntity.ok(materials);
    }

    @Override
    public ResponseEntity<Void> updateMaterial(Long materialId, MaterialRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateMaterialControllerRequestSchema,objectMapper.writeValueAsString(request));
        materialService.updateMaterial(materialId, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterial(Long materialId) {
        materialService.deleteMaterial(materialId);
        return ResponseEntity.noContent().build();
    }
}

