package in.oxidane.work.done.building.mapper;

import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;
import in.oxidane.work.done.building.entity.UnitType;
import in.oxidane.work.done.common.config.MapstructMapperConfig;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Mapper class for converting between UnitType entity and its DTOs.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface UnitTypeMapper {

    /**
     * Converts a UnitType entity to a UnitTypeResponse DTO.
     *
     * @param entity The UnitType entity to convert
     * @return The corresponding UnitTypeResponse DTO, or null if the entity is null
     */
    UnitTypeResponse toResponse(UnitType entity);

    /**
     * Converts a UnitTypeRequest DTO to a UnitType entity.
     *
     * @param request The UnitTypeRequest DTO to convert
     * @return The corresponding UnitType entity, or null if the request is null
     */
    UnitType toEntity(UnitTypeRequest request);

    List<UnitTypeResponse> toResponse(List<UnitType> unitTypes);
}
