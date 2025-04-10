package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemHeaderController;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderRequest;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderResponse;
import in.oxidane.work.done.lineitem.service.LineItemHeaderService;
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
public class LineItemHeaderControllerImpl implements LineItemHeaderController {

    private final LineItemHeaderService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemHeaderRequestSchema;
    private String updateLineItemHeaderRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_HEADER_REQUEST_SCHEMA).getInputStream()) {
            createLineItemHeaderRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_HEADER_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemHeaderRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<LineItemHeaderResponse> create(LineItemHeaderRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemHeaderRequestSchema,objectMapper.writeValueAsString(request));
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LineItemHeaderResponse> update(Long id, LineItemHeaderRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemHeaderRequestSchema,objectMapper.writeValueAsString(request));
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<LineItemHeaderResponse> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    public ResponseEntity<LineItemHeaderResponse> getByHandle(String handle) {
        return ResponseEntity.ok(service.getByHandle(handle));
    }

    @Override
    public ResponseEntity<List<LineItemHeaderResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
