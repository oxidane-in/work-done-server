package in.oxidane.work.done.worker.validator;

import in.oxidane.work.done.common.exception.ValidationException;
import in.oxidane.work.done.worker.dto.WorkerTypeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Validator for WorkerTypeRequest objects.
 * Validates input data before processing.
 */
@Component
@RequiredArgsConstructor
public class WorkerTypeValidator {

    private static final int MAX_NAME_LENGTH = 90;
    private static final int MAX_DESC_LENGTH = 255;

    /**
     * Validates a WorkerTypeRequest for creation.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(WorkerTypeRequest request) {
        List<String> errors = validateCommon(request);

        if (!errors.isEmpty()) {
            throw new ValidationException("Worker type validation failed", errors);
        }
    }

    /**
     * Validates a WorkerTypeRequest for update.
     *
     * @param request The request to validate
     * @param workerTypeId The ID of the worker type being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(WorkerTypeRequest request, Long workerTypeId) {
        List<String> errors = validateCommon(request);

        if (workerTypeId == null || workerTypeId <= 0) {
            errors.add("Worker type ID must be a positive number");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException("Worker type validation failed", errors);
        }
    }

    /**
     * Common validation logic for both create and update operations.
     *
     * @param request The request to validate
     * @return A list of validation errors, empty if validation succeeds
     */
    private List<String> validateCommon(WorkerTypeRequest request) {
        List<String> errors = new ArrayList<>();

        if (request == null) {
            errors.add("Worker type request cannot be null");
            return errors;
        }

        // Validate name
        if (!StringUtils.hasText(request.getWorkerTypeName())) {
            errors.add("Worker type name is required");
        } else if (request.getWorkerTypeName().length() > MAX_NAME_LENGTH) {
            errors.add("Worker type name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        // Validate rate
        if (request.getWorkerTypeRate() == null) {
            errors.add("Worker type rate is required");
        } else if (request.getWorkerTypeRate().compareTo(BigDecimal.ZERO) <= 0) {
            errors.add("Worker type rate must be a positive number");
        }

        // Validate description (optional but with length constraint)
        if (StringUtils.hasText(request.getWorkerTypeDesc())
                && request.getWorkerTypeDesc().length() > MAX_DESC_LENGTH) {
            errors.add("Worker type description must be less than " + MAX_DESC_LENGTH + " characters");
        }

        return errors;
    }
}
