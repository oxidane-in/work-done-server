package in.oxidane.work.done.common.validation;

import in.oxidane.work.done.common.exception.SchemaValidationError;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.everit.json.schema.ConstSchema;
import org.everit.json.schema.EnumSchema;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class EveritSchemaValidator implements Validator {
    @Override
    public void validate(String schema, String body) throws SchemaValidationException {
        try {
            JSONObject rawSchema = new JSONObject(new JSONTokener(schema));
            Schema everitSchema = SchemaLoader.load(rawSchema);
            everitSchema.validate(new JSONObject(body));
        } catch (ValidationException exception) {
            List<SchemaValidationError> errors = new ArrayList<>();
            this.handleValidationException(exception, errors);
            log.debug("JSON schema validation failed");
            throw new SchemaValidationException("Schema Validation Failed", errors);
        }
    }

    private void handleValidationException(final ValidationException e, final List<SchemaValidationError> errors) {
        if (CollectionUtils.isEmpty(e.getCausingExceptions())) {
            processSingleValidationException(e, errors);
        } else {
            processNestedValidationExceptions(e, errors);
        }
    }

    private void processSingleValidationException(final ValidationException e, final List<SchemaValidationError> errors) {
        String name = extractName(e);
        String pointer = extractPointer(e);
        String errorMsg = extractErrorMessage(e);

        if (Objects.equals(pointer, "")) {
            pointer = "/";
        }

        // Ensure errorMsg is not blank
        if (StringUtils.isBlank(errorMsg)) {
            errorMsg = e.getMessage(); // Fallback to the default exception message
        }

        // Do not combine name and errorMsg; keep them separate
        SchemaValidationError error = new SchemaValidationError(name, pointer, errorMsg);
        errors.add(error);
    }

    private void processNestedValidationExceptions(final ValidationException e, final List<SchemaValidationError> errors) {
        for (ValidationException validationException : e.getCausingExceptions()) {
            handleValidationException(validationException, errors);
        }
    }

    private String extractName(final ValidationException e) {
        String pointer = e.getPointerToViolation();
        String name = null;

        if ("required".equals(e.getKeyword())) {
            int i = e.getMessage().indexOf("[") + 1;
            int j = e.getMessage().indexOf("]", i);
            name = e.getMessage().substring(i, j);
        } else if (StringUtils.isNumeric(pointer)) {
            name = pointer.substring(1, pointer.lastIndexOf("/"));
        } else if (Objects.nonNull(pointer)) {
            int i = pointer.lastIndexOf("/");
            name = pointer.substring(i + 1);
        }

        return name;
    }

    private String extractPointer(final ValidationException e) {
        String pointer = e.getPointerToViolation();
        if (Objects.nonNull(pointer) && pointer.startsWith("#")) {
            pointer = pointer.substring(1);
        }
        return pointer;
    }

    private String extractErrorMessage(final ValidationException e) {
        String errorMsg = e.getErrorMessage();

        if ("enum".equals(e.getKeyword())) {
            String constValues = ((EnumSchema) e.getViolatedSchema()).getPossibleValues().toString();
            errorMsg = replaceParameters("Enumeration value not allowed. Allowed values are: {param}.", constValues);
        } else if ("const".equals(e.getKeyword())) {
            String constValues = ((ConstSchema) e.getViolatedSchema()).getPermittedValue().toString();
            errorMsg = replaceParameters("Allowed values are: {param}.", constValues);
        }

        return errorMsg;
    }

    private String replaceParameters(String msg, String... params) {
        String replacedMsg = msg;
        if (Objects.nonNull(params) && params.length > 0) {
            Matcher matcher = Pattern.compile("\\{[^{]*}").matcher(msg);
            int i = 0;

            while (matcher.find() && i < params.length) {
                String param;
                if (Objects.nonNull(params[i])) {
                    param = matcher.group();
                    param = param.substring(1, param.length() - 1);
                    replacedMsg = replacedMsg.replaceFirst("\\{" + param + "}", Matcher.quoteReplacement(params[i]));
                    ++i;
                } else {
                    param = matcher.group();
                    param = param.substring(1, param.length() - 1);
                    replacedMsg = replacedMsg.replaceFirst("\\{" + param + "}", Matcher.quoteReplacement(""));
                }
            }
        }
        return replacedMsg;
    }
}
