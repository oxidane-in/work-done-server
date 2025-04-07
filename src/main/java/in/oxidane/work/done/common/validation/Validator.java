package in.oxidane.work.done.common.validation;

import in.oxidane.work.done.common.exception.SchemaValidationException;
import org.everit.json.schema.ValidationException;

public interface Validator {

    void validate(String schema, String body) throws ValidationException, SchemaValidationException;
}
