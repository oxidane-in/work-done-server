package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemRequest;
import in.oxidane.work.done.lineitem.dto.LineItemResponse;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import in.oxidane.work.done.order.mapper.UnitOfMeasurementMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {UnitOfMeasurementMapper.class})
public interface LineItemMapper {

    @Mapping(target = "unitOfMeasurement", source = "unitOfMeasurementId", qualifiedByName = "uomIdToUom")
    LineItem toEntity(LineItemRequest request);

    LineItemResponse toResponse(LineItem entity);

    List<LineItemResponse> toResponse(List<LineItem> lineItems);

    @Mapping(target = "unitOfMeasurement", source = "unitOfMeasurementId", qualifiedByName = "uomIdToUom")
    LineItem toUpdateEntityFromRequest(LineItemRequest request, @MappingTarget LineItem entity);

    @Named("uomIdToUom")
    default UnitOfMeasurement uomIdToUom(Long unitOfMeasurementId) {
        if (unitOfMeasurementId == null) {
            return null;
        }

        return UnitOfMeasurement.builder()
            .uomId(unitOfMeasurementId)
            .build();
    }
}
