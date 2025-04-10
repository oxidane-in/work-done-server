package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemSubCategoryController;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryResponse;
import in.oxidane.work.done.lineitem.service.LineItemSubCategoryService;
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
public class LineItemSubCategoryControllerImpl implements LineItemSubCategoryController {

    private final LineItemSubCategoryService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemSubCategoryRequestSchema;
    private String updateLineItemSubCategoryRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_SUB_CATEGORY_REQUEST_SCHEMA).getInputStream()) {
            createLineItemSubCategoryRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_SUB_CATEGORY_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemSubCategoryRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<LineItemSubCategoryResponse> create(LineItemSubCategoryRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemSubCategoryRequestSchema,objectMapper.writeValueAsString(request));
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LineItemSubCategoryResponse> update(Long id, LineItemSubCategoryRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemSubCategoryRequestSchema,objectMapper.writeValueAsString(request));
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<LineItemSubCategoryResponse> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    public ResponseEntity<LineItemSubCategoryResponse> getByHandle(String handle) {
        return ResponseEntity.ok(service.getByHandle(handle));
    }

    @Override
    public ResponseEntity<List<LineItemSubCategoryResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
