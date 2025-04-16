package in.oxidane.work.done.shared.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.shared.dto.OtherCostItemRequest;
import in.oxidane.work.done.shared.dto.OtherCostItemResponse;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface OtherCostItemMapper {

    //OtherCostItem - request DTO to entity
    OtherCostItem toEntity(OtherCostItemRequest request);

    //OtherCostItem - entity to response DTO
    OtherCostItemResponse toResponse(OtherCostItem entity);

    //OtherCostItem - entity list to response list dto
    List<OtherCostItemResponse> toResponse(List<OtherCostItem> otherCostItems);

    //OtherCostItem - update from request to existing entity
    OtherCostItem toUpdateEntityFromRequest(OtherCostItemRequest request, @MappingTarget OtherCostItem entity);
}
