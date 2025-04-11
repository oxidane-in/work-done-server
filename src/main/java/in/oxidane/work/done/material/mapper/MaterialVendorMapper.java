package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.entity.MaterialVendor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper class for converting between MaterialVendor entity and DTOs.
 * Handles the transformation between domain entity and data transfer objects.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface MaterialVendorMapper {

    /**
     * Converts a MaterialVendorRequest DTO to a MaterialVendor entity
     *
     * @param request The MaterialVendorRequest to convert
     * @return The corresponding MaterialVendor entity
     */
    MaterialVendor toEntity(MaterialVendorRequest request);

    /**
     * Converts a MaterialVendor entity to a MaterialVendorResponse DTO
     *
     * @param entity The MaterialVendor entity to convert
     * @return The corresponding MaterialVendorResponse DTO
     */
    MaterialVendorResponse toResponse(MaterialVendor entity);

    MaterialVendor toUpdateEntityFromRequest(MaterialVendorRequest request, @MappingTarget MaterialVendor entity);
}
