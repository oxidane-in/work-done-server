package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.entity.Material;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Mapper class for converting between Material entity and DTOs.
 */
@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface MaterialMapper {

    /**
     * Converts a MaterialRequest DTO to a Material entity.
     *
     * @param request The source MaterialRequest DTO
     * @return The mapped Material entity
     */
    @Mapping(target = "materialManufacturer", source = "materialManufacturerId", qualifiedByName = "toMaterialManufacturer")
    @Mapping(target = "materialVendor", source = "materialVendorId", qualifiedByName = "toMaterialVendor")
    @Mapping(target = "materialType", source = "materialTypeId", qualifiedByName = "toMaterialType")
    @Mapping(target = "materialUOM", source = "materialUOMId", qualifiedByName = "toUnitOfMeasurement")
    Material toEntity(MaterialRequest request);

    /**
     * Updates an existing Material entity with data from MaterialRequest DTO.
     *
     * @param material The Material entity to update
     * @param request  The source MaterialRequest DTO
     * @return The updated Material entity
     */
    @Mapping(target = "materialManufacturer", source = "materialManufacturerId", qualifiedByName = "toMaterialManufacturer")
    @Mapping(target = "materialVendor", source = "materialVendorId", qualifiedByName = "toMaterialVendor")
    @Mapping(target = "materialType", source = "materialTypeId", qualifiedByName = "toMaterialType")
    @Mapping(target = "materialUOM", source = "materialUOMId", qualifiedByName = "toUnitOfMeasurement")
    Material updateEntityFromRequest(MaterialRequest request, @MappingTarget Material material);

    /**
     * Converts a Material entity to a MaterialResponse DTO.
     *
     * @param material The source Material entity
     * @return The mapped MaterialResponse DTO
     */
    MaterialResponse toResponse(Material material);

    /**
     * Converts a list of Material entities to a list of MaterialResponse DTOs.
     *
     * @param materials The source list of Material entities
     * @return The mapped list of MaterialResponse DTOs
     */
    List<MaterialResponse> toResponse(List<Material> materials);
}
