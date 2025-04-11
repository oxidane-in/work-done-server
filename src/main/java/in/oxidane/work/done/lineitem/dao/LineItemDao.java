package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItem;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for LineItem entity.
 * Provides methods to interact with the database for LineItem operations.
 */
public interface LineItemDao {

    /**
     * Retrieves a line item by its ID.
     *
     * @param id The ID of the line item to retrieve
     * @return An Optional containing the line item if found, or empty if not found
     */
    Optional<LineItem> getById(Long id);

    /**
     * Retrieves all line items.
     *
     * @return A list of all line items
     */
    List<LineItem> getAll();

    /**
     * Creates a new line item.
     *
     * @param lineItem The line item to create
     * @return The created line item with generated ID
     */
    LineItem create(LineItem lineItem);

    /**
     * Updates an existing line item.
     *
     * @param lineItem The line item to update
     * @return The updated line item
     */
    LineItem update(LineItem lineItem);

    /**
     * Deletes a line item by its ID.
     *
     * @param id The ID of the line item to delete
     */
    void delete(Long id);

    /**
     * Checks if a line item with the specified ID exists.
     *
     * @param id The ID to check
     * @return true if the line item exists, false otherwise
     */
    boolean existsById(Long id);

    /**
     * Checks if a line item with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a line item with the handle exists, false otherwise
     */
    boolean existsByHandle(String handle);

    /**
     * Checks if a line item with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id     The ID to exclude from the check
     * @return true if another line item with the handle exists, false otherwise
     */
    boolean existsByHandleAndIdNot(String handle, Long id);

    /**
     * Retrieves all line items by unit of measurement ID.
     *
     * @param uomId The unit of measurement ID to filter by
     * @return A list of line items with the specified unit of measurement ID
     */
    List<LineItem> getByUnitOfMeasurementId(Long uomId);
}
