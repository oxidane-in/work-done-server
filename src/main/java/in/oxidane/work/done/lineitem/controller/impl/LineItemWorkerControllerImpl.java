package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemWorkerController;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerRequest;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerResponse;
import in.oxidane.work.done.lineitem.service.LineItemWorkerService;
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
public class LineItemWorkerControllerImpl implements LineItemWorkerController {

    private final LineItemWorkerService service;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemWorkerRequestSchema;
    private String updateLineItemWorkerRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_WORKER_REQUEST_SCHEMA).getInputStream()) {
            createLineItemWorkerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_WORKER_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemWorkerRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<LineItemWorkerResponse> create(LineItemWorkerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemWorkerRequestSchema,objectMapper.writeValueAsString(request));
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LineItemWorkerResponse> getById(Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    public ResponseEntity<List<LineItemWorkerResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    public ResponseEntity<LineItemWorkerResponse> update(Long id, LineItemWorkerRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemWorkerRequestSchema,objectMapper.writeValueAsString(request));
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
