package in.oxidane.work.done.order.service;

import in.oxidane.work.done.order.dto.LineItemRequest;
import in.oxidane.work.done.order.dto.LineItemResponse;

import java.util.List;

/**
 * Service interface for LineItem operations.
 */
public interface LineItemService {

    /**
     * Creates a new line item.
     *
     * @param request The request containing line item details
     * @return The created line item
     */
    LineItemResponse createLineItem(LineItemRequest request);

    /**
     * Retrieves a line item by its ID.
     *
     * @param id The ID of the line item to retrieve
     * @return The line item
     */
    LineItemResponse getLineItemById(Long id);

    /**
     * Retrieves all line items.
     *
     * @return A list of all line items
     */
    List<LineItemResponse> getAllLineItems();

    /**
     * Updates an existing line item.
     *
     * @param id      The ID of the line item to update
     * @param request The request containing updated line item details
     * @return The updated line item
     */
    LineItemResponse updateLineItem(Long id, LineItemRequest request);

    /**
     * Deletes a line item by its ID.
     *
     * @param id The ID of the line item to delete
     */
    void deleteLineItem(Long id);
}
