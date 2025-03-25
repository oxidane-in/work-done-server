package in.oxidane.work.done.order.validator;

import in.oxidane.work.done.common.exception.ValidationException;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Validator class for validating UnitOfMeasurementRequest objects.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UnitOfMeasurementValidator {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_SYMBOL_LENGTH = 20;
    private static final int MAX_HANDLE_LENGTH = 50;
    private static final int MAX_DESC_LENGTH = 255;

    /**
     * Validates a request for creating a unit of measurement.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(UnitOfMeasurementRequest request) {
        log.debug("Validating unit of measurement create request");
        validateCommon(request);
    }

    /**
     * Validates a request for updating a unit of measurement.
     *
     * @param request The request to validate
     * @param id The ID of the unit of measurement being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(UnitOfMeasurementRequest request, Long id) {
        log.debug("Validating unit of measurement update request for id: {}", id);
        if (id == null) {
            throw new ValidationException("Unit of measurement ID cannot be null for update");
        }
        validateCommon(request);
    }

    /**
     * Performs common validation checks for a UnitOfMeasurementRequest.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    private void validateCommon(UnitOfMeasurementRequest request) {
        if (request == null) {
            throw new ValidationException("Unit of measurement request cannot be null");
        }

        if (!StringUtils.hasText(request.getUomName())) {
            throw new ValidationException("Unit of measurement name is required");
        }

        if (request.getUomName().length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Unit of measurement name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        if (request.getUomSymbol() != null && request.getUomSymbol().length() > MAX_SYMBOL_LENGTH) {
            throw new ValidationException("Unit of measurement symbol must be less than " + MAX_SYMBOL_LENGTH + " characters");
        }

        if (request.getUomDesc() != null && request.getUomDesc().length() > MAX_DESC_LENGTH) {
            throw new ValidationException("Unit of measurement description must be less than " + MAX_DESC_LENGTH + " characters");
        }
    }
}
