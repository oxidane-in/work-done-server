package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.entity.MaterialVendor;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between MaterialVendor entity and DTOs.
 * Handles the transformation between domain entity and data transfer objects.
 */
@Component
public class MaterialVendorMapper {

    /**
     * Converts a MaterialVendorRequest DTO to a MaterialVendor entity
     *
     * @param request The MaterialVendorRequest to convert
     * @return The corresponding MaterialVendor entity
     */
    public MaterialVendor toEntity(MaterialVendorRequest request) {
        if (request == null) {
            return null;
        }

        return MaterialVendor.builder()
                .materialVendorName(request.getMaterialVendorName())
                .materialVendorDesc(request.getMaterialVendorDesc())
                .materialVendorHandle(request.getMaterialVendorHandle())
                .build();
    }

    /**
     * Converts a MaterialVendor entity to a MaterialVendorResponse DTO
     *
     * @param entity The MaterialVendor entity to convert
     * @return The corresponding MaterialVendorResponse DTO
     */
    public MaterialVendorResponse toResponse(MaterialVendor entity) {
        if (entity == null) {
            return null;
        }

        return MaterialVendorResponse.builder()
                .materialVendorId(entity.getMaterialVendorId())
                .materialVendorName(entity.getMaterialVendorName())
                .materialVendorDesc(entity.getMaterialVendorDesc())
                .materialVendorHandle(entity.getMaterialVendorHandle())
                .build();
    }
}
