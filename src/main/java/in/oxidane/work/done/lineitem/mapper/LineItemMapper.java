package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.order.mapper.UnitOfMeasurementMapper;
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
