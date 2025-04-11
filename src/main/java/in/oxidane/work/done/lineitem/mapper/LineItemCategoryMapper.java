package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryResponse;
import in.oxidane.work.done.lineitem.entity.LineItemCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface LineItemCategoryMapper {
    
    LineItemCategoryResponse toResponse(LineItemCategory entity);
    
    LineItemCategory toEntity(LineItemCategoryRequest request);
    
    List<LineItemCategoryResponse> toResponse(List<LineItemCategory> categories);
    
    LineItemCategory toUpdateEntityFromRequest(LineItemCategoryRequest request, @MappingTarget LineItemCategory entity);
} 