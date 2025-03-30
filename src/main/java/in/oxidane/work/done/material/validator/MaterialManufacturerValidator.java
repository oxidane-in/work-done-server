package in.oxidane.work.done.material.validator;

import in.oxidane.work.done.common.exception.ValidationException;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class MaterialManufacturerValidator {

    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_DESC_LENGTH = 255;


    public void validateForCreate(MaterialManufacturerRequest request) {
        validateCommon(request);
    }

    public void validateForUpdate(MaterialManufacturerRequest request) {
        validateCommon(request);
    }

    private void validateCommon(MaterialManufacturerRequest request) {
        if (request == null) {
            throw new ValidationException("Material manufacturer request cannot be null");
        }

        if (!StringUtils.hasText(request.getMaterialManufacturerName())) {
            throw new ValidationException("Material manufacturer name is required");
        }

        if (request.getMaterialManufacturerName().length() > MAX_NAME_LENGTH) {
            throw new ValidationException("Material manufacturer name must be less than " + MAX_NAME_LENGTH + " characters");
        }

        if (request.getMaterialManufacturerDesc() != null && request.getMaterialManufacturerDesc().length() > MAX_DESC_LENGTH) {
            throw new ValidationException("Material manufacturer description must be less than " + MAX_DESC_LENGTH + " characters");
        }
    }
}
