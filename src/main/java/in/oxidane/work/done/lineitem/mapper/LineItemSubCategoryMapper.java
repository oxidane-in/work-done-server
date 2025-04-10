package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryResponse;
import in.oxidane.work.done.lineitem.entity.LineItemSubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface LineItemSubCategoryMapper {

    @Mapping(target = "lineItemCategoryId.lineItemCategoryId", source = "lineItemCategoryId")
    LineItemSubCategory toEntity(LineItemSubCategoryRequest request);

    @Mapping(target = "lineItemCategoryId", source = "lineItemCategoryId.lineItemCategoryId")
    LineItemSubCategoryResponse toResponse(LineItemSubCategory entity);

    List<LineItemSubCategoryResponse> toResponse(List<LineItemSubCategory> entities);

    @Mapping(target = "lineItemCategoryId.lineItemCategoryId", source = "lineItemCategoryId")
    LineItemSubCategory toUpdateEntityFromRequest(LineItemSubCategoryRequest request, @MappingTarget LineItemSubCategory entity);
} 