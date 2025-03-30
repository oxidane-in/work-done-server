package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.entity.Material;
import org.mapstruct.Mapper;

/**
 * Mapper class for converting between Material entity and DTOs.
 */
@Mapper(config = MapstructMapperConfig.class)
public interface MaterialMapper {

    /**
     * Converts a MaterialRequest DTO to a Material entity.
     *
     * @param request The source MaterialRequest DTO
     * @return The mapped Material entity
     */
    Material toEntity(MaterialRequest request);

    /**
     * Updates an existing Material entity with data from MaterialRequest DTO.
     *
     * @param material The Material entity to update
     * @param request  The source MaterialRequest DTO
     * @return The updated Material entity
     */
//    Material updateEntityFromRequest(Material material, MaterialRequest request);

    /**
     * Converts a Material entity to a MaterialResponse DTO.
     *
     * @param material The source Material entity
     * @return The mapped MaterialResponse DTO
     */
    MaterialResponse toResponse(Material material);
}
