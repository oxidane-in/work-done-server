package in.oxidane.work.done.lineitem.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderRequest;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderResponse;
import in.oxidane.work.done.lineitem.entity.LineItemHeader;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface LineItemHeaderMapper {
    
    LineItemHeaderResponse toResponse(LineItemHeader entity);
    
    LineItemHeader toEntity(LineItemHeaderRequest request);
    
    List<LineItemHeaderResponse> toResponse(List<LineItemHeader> lineItemHeaders);
    
    LineItemHeader toUpdateEntityFromRequest(LineItemHeaderRequest request, @MappingTarget LineItemHeader entity);
} 