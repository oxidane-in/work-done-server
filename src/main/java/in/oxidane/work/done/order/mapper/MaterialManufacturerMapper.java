package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.order.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.order.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.order.model.MaterialManufacturer;
import org.springframework.stereotype.Component;

@Component
public class MaterialManufacturerMapper {

    public MaterialManufacturer toEntity(MaterialManufacturerRequest request) {
        return MaterialManufacturer.builder()
                .materialManufacturerName(request.getName())
                .materialManufacturerDesc(request.getDescription())
                .materialManufacturerHandle(request.getHandle())
                .build();
    }

    public MaterialManufacturerResponse toResponse(MaterialManufacturer entity) {
        return MaterialManufacturerResponse.builder()
                .id(entity.getMaterialManufacturerId())
                .name(entity.getMaterialManufacturerName())
                .description(entity.getMaterialManufacturerDesc())
                .handle(entity.getMaterialManufacturerHandle())
                .build();
    }
} 