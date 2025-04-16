package in.oxidane.work.done.order.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.common.mapper.IdToEntityMapper;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualRequest;
import in.oxidane.work.done.order.dto.WorkOrderOtherCostActualResponse;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostActual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class, uses = {IdToEntityMapper.class})
public interface WorkOrderOtherCostActualMapper {

    // mapper - from request to entity
    @Mapping(source = "workOrderOtherCostPlannedId", target = "workOrderOtherCostPlanned", qualifiedByName = "toWorkOrderOtherCostPlanned")
    WorkOrderOtherCostActual toEntity(WorkOrderOtherCostActualRequest request);

    // mapper - from entity to response
    WorkOrderOtherCostActualResponse toResponse(WorkOrderOtherCostActual entity);

    //mapper - from List entity to List response
    List<WorkOrderOtherCostActualResponse> toResponse(List<WorkOrderOtherCostActual> entities);

    @Mapping(source = "workOrderOtherCostPlannedId", target = "workOrderOtherCostPlanned", qualifiedByName = "toWorkOrderOtherCostPlanned")
    WorkOrderOtherCostActual toUpdateEntityFromRequest(WorkOrderOtherCostActualRequest request, @MappingTarget WorkOrderOtherCostActual entity);

}
