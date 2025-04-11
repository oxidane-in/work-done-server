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
import java.util.Iterator;
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
            String name = null;
            String pointer = e.getPointerToViolation();
            String errorMsg = e.getErrorMessage();
            if (Objects.nonNull(pointer) && pointer.startsWith("#")) {
                pointer = pointer.substring(1);
            }

            int i;
            if (e.getKeyword().equals("required")) {
                i = e.getMessage().indexOf("[") + 1;
                int j = e.getMessage().indexOf("]", i);
                name = e.getMessage().substring(i, j);
            } else {
                String constValues;
                if (e.getKeyword().equals("enum")) {
                    constValues = ((EnumSchema) e.getViolatedSchema()).getPossibleValues().toString();
                    errorMsg = this.replaceParameters("Enumeration value not allowed. Allowed values are: {param}.", new String[]{constValues});
                } else if (e.getKeyword().equals("const")) {
                    constValues = ((ConstSchema) e.getViolatedSchema()).getPermittedValue().toString();
                    errorMsg = this.replaceParameters("Allowed values are: {param}.", new String[]{constValues});
                }
            }

            if (Objects.isNull(name) && Objects.nonNull(pointer)) {
                i = pointer.lastIndexOf("/");
                name = pointer.substring(i + 1);
            }

            if (StringUtils.isNumeric(name)) {
                name = pointer.substring(1, pointer.lastIndexOf("/"));
            }

            if (Objects.equals(pointer, "")) {
                pointer = "/";
            }

            SchemaValidationError error = new SchemaValidationError(name, errorMsg, pointer);
            errors.add(error);
        } else {
            Iterator it = e.getCausingExceptions().iterator();
            while (it.hasNext()) {
                ValidationException validationException = (ValidationException) it.next();
                this.handleValidationException(validationException, errors);
            }
        }
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
                    replacedMsg = replacedMsg.replaceFirst("\\{" + param + "\\}", Matcher.quoteReplacement(params[i]));
                    ++i;
                } else {
                    param = matcher.group();
                    param = param.substring(1, param.length() - 1);
                    replacedMsg = replacedMsg.replaceFirst("\\{" + param + "\\}", Matcher.quoteReplacement(""));
                }
            }
        }
        return replacedMsg;
    }
}
