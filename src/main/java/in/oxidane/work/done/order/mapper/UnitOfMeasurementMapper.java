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
            .uomHandleDesc(entity.getUomHandleDesc())
            .uomHandleIsActive(entity.getUomHandleIsActive())
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
        entity.setUomName(request.getUomName());
        entity.setUomSymbol(request.getUomSymbol());
        entity.setUomHandle(request.getUomHandle());
        entity.setUomHandleDesc(request.getUomHandleDesc());
        entity.setUomHandleIsActive(request.getUomHandleIsActive() != null ? request.getUomHandleIsActive() : true);
        
        return entity;
    }
} 