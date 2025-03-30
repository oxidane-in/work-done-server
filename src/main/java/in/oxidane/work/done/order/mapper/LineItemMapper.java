package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.order.dto.LineItemRequest;
import in.oxidane.work.done.order.dto.LineItemResponse;
import in.oxidane.work.done.order.entity.LineItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {UnitOfMeasurementMapper.class})
public interface LineItemMapper {

    @Mapping(target = "unitOfMeasurement", ignore = true)
    LineItem toEntity(LineItemRequest request);

    @Mapping(source = "unitOfMeasurement", target = "unitOfMeasurement")
    LineItemResponse toResponse(LineItem entity);

    List<LineItemResponse> toResponse(List<LineItem> lineItems);

    @Mapping(target = "unitOfMeasurement", ignore = true)
    @Mapping(target = "lineItemId", ignore = true)
    LineItem toUpdateEntityFromRequest(LineItemRequest request, @MappingTarget LineItem entity);
} 