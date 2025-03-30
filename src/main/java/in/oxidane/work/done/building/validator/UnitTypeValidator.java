package in.oxidane.work.done.building.validator;

import in.oxidane.work.done.common.exception.ValidationException;
import in.oxidane.work.done.building.dto.UnitTypeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Validator class for validating UnitTypeRequest objects.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UnitTypeValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_DESC_LENGTH = 255;

    /**
     * Validates a request for creating a unit type.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(UnitTypeRequest request) {
        log.debug("Validating unit type create request");
        validateCommon(request);
    }

    /**
     * Validates a request for updating a unit type.
     *
     * @param request The request to validate
     * @param id The ID of the unit type being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(UnitTypeRequest request, Long id) {
        log.debug("Validating unit type update request for id: {}", id);
        if (id == null) {
            throw new ValidationException("Unit type ID cannot be null for update");
        }

        validateCommon(request);
    }

    /**
     * Performs common validation checks for a UnitTypeRequest.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    private void validateCommon(UnitTypeRequest request) {
        if (request == null) {
            throw new ValidationException("Unit type request cannot be null");
        }

        if (!StringUtils.hasText(request.getUnitTypeName())) {
            throw new ValidationException("Unit type name is required");
        }

        if (request.getUnitTypeName().length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Unit type name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        if (request.getUnitTypeDesc() != null && request.getUnitTypeDesc().length() > MAX_DESC_LENGTH) {
            throw new ValidationException("Unit type description must be less than " + MAX_DESC_LENGTH + " characters");
        }
    }
}
