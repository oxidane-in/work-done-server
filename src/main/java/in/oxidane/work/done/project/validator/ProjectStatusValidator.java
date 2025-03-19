package in.oxidane.work.done.project.validator;

import in.oxidane.work.done.exception.ValidationException;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Validator class for validating ProjectStatusRequest objects.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectStatusValidator {

    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_HANDLE_LENGTH = 50;
    private static final int MAX_DESC_LENGTH = 255;

    /**
     * Validates a request for creating a project status.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(ProjectStatusRequest request) {
        log.debug("Validating project status create request");
        validateCommon(request);
    }

    /**
     * Validates a request for updating a project status.
     *
     * @param request The request to validate
     * @param id The ID of the project status being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(ProjectStatusRequest request, Integer id) {
        log.debug("Validating project status update request for id: {}", id);
        if (id == null) {
            throw new ValidationException("Project status ID cannot be null for update");
        }
        validateCommon(request);
    }

    /**
     * Performs common validation checks for a ProjectStatusRequest.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    private void validateCommon(ProjectStatusRequest request) {
        if (request == null) {
            throw new ValidationException("Project status request cannot be null");
        }

        if (!StringUtils.hasText(request.getProjectStatusName())) {
            throw new ValidationException("Project status name is required");
        }

        if (request.getProjectStatusName().length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Project status name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        if (request.getProjectStatusHandle() != null && request.getProjectStatusHandle().length() > MAX_HANDLE_LENGTH) {
            throw new ValidationException("Project status handle must be less than " + MAX_HANDLE_LENGTH + " characters");
        }

        if (request.getProjectStatusDesc() != null && request.getProjectStatusDesc().length() > MAX_DESC_LENGTH) {
            throw new ValidationException("Project status description must be less than " + MAX_DESC_LENGTH + " characters");
        }
    }
}
