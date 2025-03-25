package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between UnitOfMeasurement entity and its DTOs.
 */
@Component
public class UnitOfMeasurementMapper {

    /**
     * Converts a UnitOfMeasurement entity to a UnitOfMeasurementResponse DTO.
     *
     * @param entity The UnitOfMeasurement entity to convert
     * @return The corresponding UnitOfMeasurementResponse DTO, or null if the entity is null
     */
    public UnitOfMeasurementResponse toResponse(UnitOfMeasurement entity) {
        if (entity == null) {
            return null;
        }

        return UnitOfMeasurementResponse.builder()
            .uomId(entity.getUomId())
            .uomName(entity.getUomName())
            .uomSymbol(entity.getUomSymbol())
            .uomHandle(entity.getUomHandle())
            .uomDesc(entity.getUomDesc())
            .build();
    }

    /**
     * Converts a UnitOfMeasurementRequest DTO to a UnitOfMeasurement entity.
     *
     * @param request The UnitOfMeasurementRequest DTO to convert
     * @return The corresponding UnitOfMeasurement entity, or null if the request is null
     */
    public UnitOfMeasurement toEntity(UnitOfMeasurementRequest request) {
        if (request == null) {
            return null;
        }

        UnitOfMeasurement entity = new UnitOfMeasurement();
        entity.toBuilder()
            .uomName(request.getUomName())
            .uomSymbol(request.getUomSymbol())
            .uomDesc(request.getUomDesc())
            .build();

        return entity;
    }
}
