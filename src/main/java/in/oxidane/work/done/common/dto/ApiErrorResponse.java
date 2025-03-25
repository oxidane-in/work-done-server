package in.oxidane.work.done.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Unified error response class for API errors.
 * Used for both regular errors and validation errors.
 * For validation errors, the errorMessages list contains validation failure details.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    /**
     * List of specific error messages.
     * Only populated for validation errors.
     * For non-validation errors, this will be null or empty.
     */
    private List<String> errorMessages;
}
