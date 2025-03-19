package in.oxidane.work.done.material.mapper;

import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.entity.MaterialType;
import org.springframework.stereotype.Component;

@Component
public class MaterialTypeMapper {

    public MaterialType toEntity(MaterialTypeRequest request) {
        return MaterialType.builder()
                .materialTypeName(request.getMaterialTypeName())
                .materialTypeDesc(request.getMaterialTypeDesc())
                .materialTypeHandle(request.getMaterialTypeHandle())
                .build();
    }

    public MaterialTypeResponse toResponse(MaterialType entity) {
        return MaterialTypeResponse.builder()
                .materialTypeId(entity.getMaterialTypeId())
                .materialTypeName(entity.getMaterialTypeName())
                .materialTypeDesc(entity.getMaterialTypeDesc())
                .materialTypeHandle(entity.getMaterialTypeHandle())
                .build();
    }
}
