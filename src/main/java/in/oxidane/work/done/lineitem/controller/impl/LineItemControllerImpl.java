package in.oxidane.work.done.lineitem.controller.impl;

import in.oxidane.work.done.lineitem.controller.LineItemController;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import in.oxidane.work.done.lineitem.service.LineItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the LineItemController interface.
 * Handles HTTP requests related to line item operations.
 */
@RestController
@RequiredArgsConstructor
public class LineItemControllerImpl implements LineItemController {

    private final LineItemService lineItemService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<LineItemResponse> createLineItem(LineItemRequest request) {
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
    public ResponseEntity<LineItemResponse> updateLineItem(Long id, LineItemRequest request) {
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
