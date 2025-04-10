package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemCategoryController;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryResponse;
import in.oxidane.work.done.lineitem.service.LineItemCategoryService;
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
public class LineItemCategoryControllerImpl implements LineItemCategoryController {

    private final LineItemCategoryService lineItemCategoryService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemCategoryRequestSchema;
    private String updateLineItemCategoryRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_CATEGORY_REQUEST_SCHEMA).getInputStream()) {
            createLineItemCategoryRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_CATEGORY_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemCategoryRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<LineItemCategoryResponse> create(LineItemCategoryRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemCategoryRequestSchema,objectMapper.writeValueAsString(request));
        return new ResponseEntity<>(lineItemCategoryService.create(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LineItemCategoryResponse> update( Long id, LineItemCategoryRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemCategoryRequestSchema,objectMapper.writeValueAsString(request));
        return ResponseEntity.ok(lineItemCategoryService.update(id, request));
    }

    @Override
    public ResponseEntity<LineItemCategoryResponse> getById(Long id) {
        return ResponseEntity.ok(lineItemCategoryService.getById(id));
    }

    @Override
    public ResponseEntity<LineItemCategoryResponse> getByHandle(String handle) {
        return ResponseEntity.ok(lineItemCategoryService.getByHandle(handle));
    }

    @Override
    public ResponseEntity<List<LineItemCategoryResponse>> getAll() {
        return ResponseEntity.ok(lineItemCategoryService.getAll());
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        lineItemCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
