package in.oxidane.work.done.material.validator;

import in.oxidane.work.done.exception.ValidationException;
import in.oxidane.work.done.material.dao.MaterialManufacturerDao;
import in.oxidane.work.done.material.dao.MaterialTypeDao;
import in.oxidane.work.done.material.dao.MaterialVendorDao;
import in.oxidane.work.done.material.dto.MaterialRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Validator for MaterialRequest objects.
 * Validates input data before processing.
 */
@Component
@RequiredArgsConstructor
public class MaterialRequestValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_UNIT_LENGTH = 20;

    private final MaterialManufacturerDao materialManufacturerDao;
    private final MaterialVendorDao materialVendorDao;
    private final MaterialTypeDao materialTypeDao;

    /**
     * Validates a MaterialRequest for creation.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(MaterialRequest request) {
        List<String> errors = validateCommon(request);

        if (!errors.isEmpty()) {
            throw new ValidationException("Material validation failed", errors);
        }
    }

    /**
     * Validates a MaterialRequest for update.
     *
     * @param request The request to validate
     * @param materialId The ID of the material being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(MaterialRequest request, Integer materialId) {
        List<String> errors = validateCommon(request);

        if (materialId == null || materialId <= 0) {
            errors.add("Material ID must be a positive number");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException("Material validation failed", errors);
        }
    }

    /**
     * Common validation logic for both create and update operations.
     *
     * @param request The request to validate
     * @return A list of validation errors, empty if validation succeeds
     */
    private List<String> validateCommon(MaterialRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Material request cannot be null");
            return errors;
        }

        // Validate name
        if (!StringUtils.hasText(request.getMaterialName())) {
            errors.add("Material name is required");
        } else if (request.getMaterialName().length() > MAX_NAME_LENGTH) {
            errors.add("Material name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        // Validate unit (optional but with length constraint)
        if (StringUtils.hasText(request.getMaterialUnit())
                && request.getMaterialUnit().length() > MAX_UNIT_LENGTH) {
            errors.add("Material unit must be less than " + MAX_UNIT_LENGTH + " characters");
        }

        // Validate pack size
        if (request.getMaterialPackSize() == null) {
            errors.add("Material pack size is required");
        } else if (request.getMaterialPackSize().compareTo(BigDecimal.ZERO) <= 0) {
            errors.add("Material pack size must be a positive number");
        }

        // Validate rate per pack (optional but positive)
        if (request.getMaterialRatePerPack() != null
                && request.getMaterialRatePerPack().compareTo(BigDecimal.ZERO) < 0) {
            errors.add("Material rate per pack must not be negative");
        }

        // Validate rate per unit (optional but positive)
        if (request.getMaterialRatePerUnit() != null
                && request.getMaterialRatePerUnit().compareTo(BigDecimal.ZERO) < 0) {
            errors.add("Material rate per unit must not be negative");
        }

        // Validate references to related entities
        validateRelatedEntities(request, errors);

        return errors;
    }

    /**
     * Validates that referenced entities exist in the database.
     *
     * @param request The request to validate
     * @param errors The list of errors to add to if validation fails
     */
    private void validateRelatedEntities(MaterialRequest request, List<String> errors) {
        // Validate manufacturer if specified
        if (request.getMaterialManufacturerId() != null) {
            if (request.getMaterialManufacturerId() <= 0) {
                errors.add("Material manufacturer ID must be a positive number");
            } else if (!materialManufacturerDao.existsById(request.getMaterialManufacturerId())) {
                errors.add("Material manufacturer with ID " + request.getMaterialManufacturerId() + " does not exist");
            }
        }

        // Validate vendor if specified
        if (request.getMaterialVendorId() != null) {
            if (request.getMaterialVendorId() <= 0) {
                errors.add("Material vendor ID must be a positive number");
            } else if (!materialVendorDao.existsById(request.getMaterialVendorId())) {
                errors.add("Material vendor with ID " + request.getMaterialVendorId() + " does not exist");
            }
        }

        // Validate type if specified
        if (request.getMaterialTypeId() != null) {
            if (request.getMaterialTypeId() <= 0) {
                errors.add("Material type ID must be a positive number");
            } else if (!materialTypeDao.existsById(request.getMaterialTypeId())) {
                errors.add("Material type with ID " + request.getMaterialTypeId() + " does not exist");
            }
        }
    }
}
