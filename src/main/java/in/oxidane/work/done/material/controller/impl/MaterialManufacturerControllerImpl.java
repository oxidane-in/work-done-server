package in.oxidane.work.done.material.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.material.controller.MaterialManufacturerController;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.material.service.MaterialManufacturerService;
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
public class MaterialManufacturerControllerImpl implements MaterialManufacturerController {

    private final MaterialManufacturerService materialManufacturerService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createMaterialManufacturerControllerRequestSchema;
    private String updateMaterialManufacturerControllerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_MATERIAL_MANUFACTURER_REQUEST_SCHEMA).getInputStream()) {
            createMaterialManufacturerControllerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_MATERIAL_MANUFACTURER_REQUEST_SCHEMA).getInputStream()) {
            updateMaterialManufacturerControllerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> createMaterialManufacturer(MaterialManufacturerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createMaterialManufacturerControllerRequestSchema,objectMapper.writeValueAsString(request));
        MaterialManufacturerResponse response = materialManufacturerService.createMaterialManufacturer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> getMaterialManufacturerById(Long id) {
        MaterialManufacturerResponse response = materialManufacturerService.getMaterialManufacturerById(id);
        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<List<MaterialManufacturerResponse>> getAllMaterialManufacturers() {
        List<MaterialManufacturerResponse> responses = materialManufacturerService.getAllMaterialManufacturers();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialManufacturer(Long id, MaterialManufacturerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateMaterialManufacturerControllerRequestSchema,objectMapper.writeValueAsString(request));
        materialManufacturerService.updateMaterialManufacturer(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialManufacturer(Long id) {
        materialManufacturerService.deleteMaterialManufacturer(id);
        return ResponseEntity.noContent().build();
    }
}
