package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.material.entity.MaterialManufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructMapperConfig.class)
public interface MaterialManufacturerMapper {

    MaterialManufacturer toEntity(MaterialManufacturerRequest request);

    MaterialManufacturerResponse toResponse(MaterialManufacturer entity);

    MaterialManufacturer toUpdateEntityFromRequest(MaterialManufacturerRequest request, @MappingTarget MaterialManufacturer entity);
}
