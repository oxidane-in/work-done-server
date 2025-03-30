package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.entity.MaterialType;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructMapperConfig.class)
public interface MaterialTypeMapper {

    MaterialType toEntity(MaterialTypeRequest request);

    MaterialTypeResponse toResponse(MaterialType entity);

    MaterialType toUpdateEntityFromRequest(MaterialTypeRequest request, @MappingTarget MaterialType entity);
}
