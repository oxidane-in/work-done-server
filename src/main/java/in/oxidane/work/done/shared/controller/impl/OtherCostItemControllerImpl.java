package in.oxidane.work.done.shared.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.shared.controller.OtherCostItemController;
import in.oxidane.work.done.shared.dto.OtherCostItemRequest;
import in.oxidane.work.done.shared.dto.OtherCostItemResponse;
import in.oxidane.work.done.shared.service.OtherCostItemService;
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

@RestController
@RequiredArgsConstructor
public class OtherCostItemControllerImpl implements OtherCostItemController {

    private final OtherCostItemService otherCostItemService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createOtherCostItemRequestSchema;
    private String updateOtherCostItemRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_OTHER_COST_ITEM_REQUEST_SCHEMA).getInputStream()) {
            createOtherCostItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_OTHER_COST_ITEM_REQUEST_SCHEMA).getInputStream()) {
            updateOtherCostItemRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<OtherCostItemResponse> createOtherCostItem(OtherCostItemRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createOtherCostItemRequestSchema, objectMapper.writeValueAsString(request));
       OtherCostItemResponse otherCostItem = otherCostItemService.createOtherCostItem(request);
       return new ResponseEntity<>(otherCostItem, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OtherCostItemResponse> getOtherCostItemById(Long id) {
        OtherCostItemResponse otherCostItem = otherCostItemService.getOtherCostItemById(id);
        return ResponseEntity.ok(otherCostItem);
    }

    @Override
    public ResponseEntity<List<OtherCostItemResponse>> getAllOtherCostItems() {
        List<OtherCostItemResponse> otherCostItems = otherCostItemService.getAllOtherCostItems();
        return ResponseEntity.ok(otherCostItems);
    }

    @Override
    public ResponseEntity<OtherCostItemResponse> updateOtherCostItem(Long id, OtherCostItemRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateOtherCostItemRequestSchema, objectMapper.writeValueAsString(request));
       OtherCostItemResponse otherCostItem = otherCostItemService.updateOtherItemCost(id, request);
       return  ResponseEntity.ok(otherCostItem);
    }

    @Override
    public ResponseEntity<Void> deleteOtherCostItem(Long id) {
        otherCostItemService.deleteOtherCostItem(id);
        return ResponseEntity.noContent().build();
    }
}
