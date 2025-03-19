package in.oxidane.work.done.project.validator;

import in.oxidane.work.done.exception.ValidationException;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Validator class for validating ProjectScopeRequest objects.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectScopeValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_HANDLE_LENGTH = 50;
    private static final int MAX_DESC_LENGTH = 255;

    /**
     * Validates a request for creating a project scope.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    public void validateForCreate(ProjectScopeRequest request) {
        log.debug("Validating project scope create request");
        validateCommon(request);
    }

    /**
     * Validates a request for updating a project scope.
     *
     * @param request The request to validate
     * @param id The ID of the project scope being updated
     * @throws ValidationException if validation fails
     */
    public void validateForUpdate(ProjectScopeRequest request, Integer id) {
        log.debug("Validating project scope update request for id: {}", id);
        if (id == null) {
            throw new ValidationException("Project scope ID cannot be null for update");
        }
        validateCommon(request);
    }

    /**
     * Performs common validation checks for a ProjectScopeRequest.
     *
     * @param request The request to validate
     * @throws ValidationException if validation fails
     */
    private void validateCommon(ProjectScopeRequest request) {
        if (request == null) {
            throw new ValidationException("Project scope request cannot be null");
        }

        if (!StringUtils.hasText(request.getProjectScopeName())) {
            throw new ValidationException("Project scope name is required");
        }

        if (request.getProjectScopeName().length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Project scope name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        if (request.getProjectScopeHandle() != null && request.getProjectScopeHandle().length() > MAX_HANDLE_LENGTH) {
            throw new ValidationException("Project scope handle must be less than " + MAX_HANDLE_LENGTH + " characters");
        }

        if (request.getProjectScopeDesc() != null && request.getProjectScopeDesc().length() > MAX_DESC_LENGTH) {
            throw new ValidationException("Project scope description must be less than " + MAX_DESC_LENGTH + " characters");
        }
    }
}
