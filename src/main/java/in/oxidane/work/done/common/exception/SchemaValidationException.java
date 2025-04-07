package in.oxidane.work.done.common.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SchemaValidationException extends Exception {
    private List<SchemaValidationError> errors = new ArrayList<>();

    public SchemaValidationException(final String message, final List<SchemaValidationError> errors) {
        super(message);
        this.errors.addAll(errors);
        getErrors();
    }

    public List<SchemaValidationError> getErrors() {
        return Collections.unmodifiableList(this.errors);
    }
}
