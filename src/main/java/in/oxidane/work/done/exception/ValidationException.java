package in.oxidane.work.done.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception thrown when request validation fails.
 * Contains details about validation errors.
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private final List<String> errors;

    public ValidationException(String message) {
        super(message);
        this.errors = new ArrayList<>();
        this.errors.add(message);
    }

    public ValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        if (errors.size() == 1) {
            return super.getMessage();
        }

        StringBuilder message = new StringBuilder(super.getMessage());
        message.append(": ");
        for (int i = 0; i < errors.size(); i++) {
            if (i > 0) {
                message.append("; ");
            }
            message.append(errors.get(i));
        }

        return message.toString();
    }
}
