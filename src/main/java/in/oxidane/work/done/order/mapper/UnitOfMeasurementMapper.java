package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper class for converting between UnitOfMeasurement entity and its DTOs.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface UnitOfMeasurementMapper {

    /**
     * Converts a UnitOfMeasurement entity to a UnitOfMeasurementResponse DTO.
     *
     * @param entity The UnitOfMeasurement entity to convert
     * @return The corresponding UnitOfMeasurementResponse DTO, or null if the entity is null
     */
    UnitOfMeasurementResponse toResponse(UnitOfMeasurement entity);

    /**
     * Converts a UnitOfMeasurementRequest DTO to a UnitOfMeasurement entity.
     *
     * @param request The UnitOfMeasurementRequest DTO to convert
     * @return The corresponding UnitOfMeasurement entity, or null if the request is null
     */
    UnitOfMeasurement toEntity(UnitOfMeasurementRequest request);

    UnitOfMeasurement toUpdateEntityFromRequest(UnitOfMeasurementRequest request, @MappingTarget UnitOfMeasurement entity);
}
