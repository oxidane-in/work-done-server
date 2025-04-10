package in.oxidane.work.done.material.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.material.controller.MaterialVendorController;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.service.MaterialVendorService;
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

/**
 * Implementation of the MaterialVendorController Longerface.
 * Provides REST API endpoints for managing material vendors.
 */
@RestController
@RequiredArgsConstructor
public class MaterialVendorControllerImpl implements MaterialVendorController {

    private final MaterialVendorService materialVendorService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createMaterialVendorControllerRequestSchema;
    private String updateMaterialVendorControllerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_MATERIAL_VENDOR_REQUEST_SCHEMA).getInputStream()) {
            createMaterialVendorControllerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_MATERIAL_VENDOR_REQUEST_SCHEMA).getInputStream()) {
            updateMaterialVendorControllerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> createMaterialVendor(MaterialVendorRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createMaterialVendorControllerRequestSchema,objectMapper.writeValueAsString(request));
        MaterialVendorResponse response = materialVendorService.createMaterialVendor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> getMaterialVendorById(Long id) {
        MaterialVendorResponse response = materialVendorService.getMaterialVendorById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialVendorResponse>> getAllMaterialVendors() {
        List<MaterialVendorResponse> responses = materialVendorService.getAllMaterialVendors();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialVendor(Long id, MaterialVendorRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateMaterialVendorControllerRequestSchema,objectMapper.writeValueAsString(request));
        materialVendorService.updateMaterialVendor(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialVendor(Long id) {
        materialVendorService.deleteMaterialVendor(id);
        return ResponseEntity.noContent().build();
    }
}
