package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialRequest;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialResponse;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.lineitem.entity.LineItemMaterial;
import in.oxidane.work.done.material.entity.Material;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface LineItemMaterialMapper {

    @Mapping(target = "lineItemId", source = "lineItem.lineItemId")
    @Mapping(target = "materialId", source = "material.materialId")
    LineItemMaterialResponse toResponse(LineItemMaterial entity);

    List<LineItemMaterialResponse> toResponse(List<LineItemMaterial> entities);

    @Mapping(target = "lineItem.lineItemId", source = "lineItemId")
    @Mapping(target = "material.materialId", source = "materialId")
    @Mapping(target = "lineItemMaterialId", ignore = true)
    LineItemMaterial toEntity(LineItemMaterialRequest request);

    @Mapping(target = "lineItem", expression = "java(lineItemIdToLineItem(request.getLineItemId()))")
    @Mapping(target = "material", expression = "java(materialIdToMaterial(request.getMaterialId()))")
    LineItemMaterial toUpdateEntityFromRequest(LineItemMaterialRequest request);

    @Named("lineItemIdToLineItem")
    default LineItem lineItemIdToLineItem(Long lineItemId) {
        if (lineItemId == null) {
            return null;
        }
        return LineItem.builder().lineItemId(lineItemId).build();
    }

    @Named("materialIdToMaterial")
    default Material materialIdToMaterial(Long materialId) {
        if (materialId == null) {
            return null;
        }
        return Material.builder().materialId(materialId).build();
    }
}
