package in.oxidane.work.done.exception;

import in.oxidane.work.done.dto.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private String getRequestPath(WebRequest request) {
        return request != null ? request.getDescription(false) : "unknown";
    }

    private void setupMDC() {
        if (MDC.get("requestId") == null) {
            MDC.put("requestId", UUID.randomUUID().toString());
        }
    }

    // Generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        setupMDC();
        logger.error("Unhandled exception occurred", ex);
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("An unexpected error occurred: " + ex.getMessage())
                .path(getRequestPath(request))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        setupMDC();
        logger.warn("Resource not found: {}", ex.getMessage());
        ApiErrorResponse errorResponse = ApiErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(HttpStatus.NOT_FOUND.value())
            .error("Not Found")
            .message(ex.getMessage())
            .path(getRequestPath(request))
            .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(ValidationException ex, WebRequest request) {
        setupMDC();
        logger.error("Validation error: {}", ex.getMessage());
        
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message("Validation failed")
                .errorMessages(ex.getErrors())
                .path(getRequestPath(request))
                .build();
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        setupMDC();
        logger.error("Method argument validation failed: {}", ex.getMessage());
        
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        
        List<String> errorList = new ArrayList<>(errorMap.values());
        
        ApiErrorResponse response = ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Bad Request")
                .message("Validation failed")
                .errorMessages(errorList)
                .path(getRequestPath(request))
                .build();
        
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
