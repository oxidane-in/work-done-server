package in.oxidane.work.done.lineitem.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.lineitem.controller.LineItemController;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import in.oxidane.work.done.lineitem.service.LineItemService;
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
 * Implementation of the LineItemController interface.
 * Handles HTTP requests related to line item operations.
 */
@RestController
@RequiredArgsConstructor
public class LineItemControllerImpl implements LineItemController {

    private final LineItemService lineItemService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createLineItemRequestSchema;
    private String updateLineItemRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_LINE_ITEM_REQUEST_SCHEMA).getInputStream()) {
            createLineItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_LINE_ITEM_REQUEST_SCHEMA).getInputStream()) {
            updateLineItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<LineItemResponse> createLineItem(LineItemRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createLineItemRequestSchema,objectMapper.writeValueAsString(request));
        LineItemResponse response = lineItemService.createLineItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<LineItemResponse> getLineItemById(Long id) {
        LineItemResponse response = lineItemService.getLineItemById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<LineItemResponse>> getAllLineItems() {
        List<LineItemResponse> response = lineItemService.getAllLineItems();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<LineItemResponse> updateLineItem(Long id, LineItemRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateLineItemRequestSchema,objectMapper.writeValueAsString(request));
        LineItemResponse response = lineItemService.updateLineItem(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteLineItem(Long id) {
        lineItemService.deleteLineItem(id);
        return ResponseEntity.noContent().build();
    }
}
