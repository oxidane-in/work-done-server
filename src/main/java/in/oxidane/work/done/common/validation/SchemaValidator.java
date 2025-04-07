package in.oxidane.work.done.common.validation;

import in.oxidane.work.done.common.exception.SchemaValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SchemaValidator {

    private final EveritSchemaValidator schemaValidator;

    public void validate(String schema, String body) throws SchemaValidationException {
        this.schemaValidator.validate(schema, body);
    }
}
