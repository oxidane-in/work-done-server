package in.oxidane.work.done.building.mapper;

import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;
import in.oxidane.work.done.building.entity.UnitType;
import org.springframework.stereotype.Component;

/**
 * Mapper class for converting between UnitType entity and its DTOs.
 */
@Component
public class UnitTypeMapper {

    /**
     * Converts a UnitType entity to a UnitTypeResponse DTO.
     *
     * @param entity The UnitType entity to convert
     * @return The corresponding UnitTypeResponse DTO, or null if the entity is null
     */
    public UnitTypeResponse toResponse(UnitType entity) {
        if (entity == null) {
            return null;
        }
        
        return UnitTypeResponse.builder()
            .unitTypeId(entity.getUnitTypeId())
            .unitTypeName(entity.getUnitTypeName())
            .unitTypeHandle(entity.getUnitTypeHandle())
            .unitTypeDesc(entity.getUnitTypeDesc())
            .isActive(entity.getIsActive())
            .build();
    }

    /**
     * Converts a UnitTypeRequest DTO to a UnitType entity.
     *
     * @param request The UnitTypeRequest DTO to convert
     * @return The corresponding UnitType entity, or null if the request is null
     */
    public UnitType toEntity(UnitTypeRequest request) {
        if (request == null) {
            return null;
        }
        
        UnitType entity = new UnitType();
        entity.setUnitTypeName(request.getUnitTypeName());
        entity.setUnitTypeHandle(request.getUnitTypeHandle());
        entity.setUnitTypeDesc(request.getUnitTypeDesc());
        entity.setIsActive(request.getIsActive() != null ? request.getIsActive() : true);
        
        return entity;
    }
} 