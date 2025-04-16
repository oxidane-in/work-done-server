package in.oxidane.work.done.common.mapper;

import in.oxidane.work.done.common.config.MapstructMapperConfig;
import in.oxidane.work.done.lineitem.entity.LineItem;
import in.oxidane.work.done.material.entity.MaterialManufacturer;
import in.oxidane.work.done.material.entity.MaterialType;
import in.oxidane.work.done.material.entity.MaterialVendor;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import in.oxidane.work.done.order.entity.WorkOrder;
import in.oxidane.work.done.order.entity.WorkOrderLineItems;
import in.oxidane.work.done.order.entity.WorkOrderOtherCostPlanned;
import in.oxidane.work.done.order.mapper.WorkOrderLineItemsMapper;
import in.oxidane.work.done.order.mapper.WorkOrderMapper;
import in.oxidane.work.done.project.entity.*;
import in.oxidane.work.done.project.mapper.ClientMapper;
import in.oxidane.work.done.project.mapper.ProjectStatusMapper;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import in.oxidane.work.done.worker.entity.WorkerType;
import in.oxidane.work.done.worker.mapper.WorkerTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(config = MapstructMapperConfig.class,
        uses = {WorkOrderMapper.class, WorkOrderLineItemsMapper.class, WorkerTypeMapper.class, ClientMapper.class, ProjectStatusMapper.class, ProjectOtherCostActual.class})
public interface IdToEntityMapper {

    @Named("toWorkOrder")
    default WorkOrder toWorkOrder(Long workOrderId) {
        if (workOrderId == null) return null;
        return WorkOrder.builder().workOrderId(workOrderId).build();
    }

    @Named("toWorkOrderLineItems")
    default WorkOrderLineItems toWorkOrderLineItems(Long lineItemId) {
        if (lineItemId == null) return null;
        return WorkOrderLineItems.builder().woLineItemId(lineItemId).build();
    }

    @Named("toWorkerType")
    default WorkerType toWorkerType(Long workerTypeId) {
        if (workerTypeId == null) return null;
        return WorkerType.builder().workerTypeId(workerTypeId).build();
    }

    @Named("toClient")
    default Client toClient(Long id) {
        if (id == null) return null;
        return Client.builder().clientId(id).build();
    }

    @Named("toProjectStatus")
    default ProjectStatus toProjectStatus(Long id) {
        if (id == null) return null;
        return ProjectStatus.builder().projectStatusId(id).build();
    }

    @Named("toLineItem")
    default LineItem toLineItem(Long lineItemId) {
        if (lineItemId == null) return null;
        return LineItem.builder().lineItemId(lineItemId).build();
    }

    @Named("toProject")
    default Project toProject(Long projectId) {
        if (projectId == null) return null;
        return Project.builder().projectId(projectId).build();
    }

    @Named("toMaterialManufacturer")
    default MaterialManufacturer toMaterialManufacturer(Long id) {
        if (id == null) return null;
        return MaterialManufacturer.builder().materialManufacturerId(id).build();
    }

    @Named("toMaterialVendor")
    default MaterialVendor toMaterialVendor(Long id) {
        if (id == null) return null;
        return MaterialVendor.builder().materialVendorId(id).build();
    }

    @Named("toMaterialType")
    default MaterialType toMaterialType(Long id) {
        if (id == null) return null;
        return MaterialType.builder().materialTypeId(id).build();
    }

    @Named("toUnitOfMeasurement")
    default UnitOfMeasurement toUnitOfMeasurement(Long id) {
        if (id == null) return null;
        return UnitOfMeasurement.builder().uomId(id).build();
    }

    @Named("toProjectOtherCostPlanned")
    default ProjectOtherCostPlanned toProjectOtherCostPlanned(Long id){
        if (id == null) return null;
        return ProjectOtherCostPlanned.builder().projectOtherCostPlannedId(id).build();
    }

    @Named("toOtherCostItem")
    default OtherCostItem toOtherCostItem(Long id){
        if (id == null) return null;
        return OtherCostItem.builder().otherCostItemId(id).build();
    }

    @Named("toWorkOrderOtherCostActualPlanned")
    default WorkOrderOtherCostPlanned toWorkOrderOtherCostActualPlanned(Long id){
        if(id == null) return null;
        return WorkOrderOtherCostPlanned.builder().woOtherCostPlannedId(id).build();
    }

}
