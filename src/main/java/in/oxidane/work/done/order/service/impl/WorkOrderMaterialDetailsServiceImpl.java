package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.order.dao.WorkOrderMaterialDetailsDao;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsRequest;
import in.oxidane.work.done.order.dto.WorkOrderMaterialDetailsResponse;
import in.oxidane.work.done.order.entity.WorkOrderMaterialDetails;
import in.oxidane.work.done.order.mapper.WorkOrderMaterialDetailsMapper;
import in.oxidane.work.done.order.service.WorkOrderMaterialDetailsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkOrderMaterialDetailsServiceImpl implements WorkOrderMaterialDetailsService {

    private final WorkOrderMaterialDetailsDao dao;
    private final WorkOrderMaterialDetailsMapper mapper;

    @Override
    public WorkOrderMaterialDetailsResponse create(WorkOrderMaterialDetailsRequest request) {
        log.info("Creating new work order material detail for work order ID: {} and line item ID: {}",
            request.getWorkOrderId(), request.getWoLineItemId());

        WorkOrderMaterialDetails material = mapper.toEntity(request);
        WorkOrderMaterialDetails savedMaterial = dao.save(material);

        log.info("Created work order material detail with ID: {}", savedMaterial.getWoMaterialDetailId());
        return mapper.toResponse(savedMaterial);
    }

    @Override
    public WorkOrderMaterialDetailsResponse update(Long id, WorkOrderMaterialDetailsRequest request) {
        log.info("Updating work order material detail with ID: {}", id);

        WorkOrderMaterialDetails existingMaterial = dao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Work order material detail not found with ID: " + id));

        WorkOrderMaterialDetails updatedMaterial = mapper.toUpdateEntityFromRequest(request, existingMaterial);
        WorkOrderMaterialDetails savedMaterial = dao.save(updatedMaterial);

        log.info("Updated work order material detail with ID: {}", id);
        return mapper.toResponse(savedMaterial);
    }

    @Override
    public WorkOrderMaterialDetailsResponse getById(Long id) {
        log.info("Fetching work order material detail by ID: {}", id);

        return dao.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Work order material detail not found with ID: " + id));
    }

    @Override
    public List<WorkOrderMaterialDetailsResponse> getByWorkOrderId(Long workOrderId) {
        log.info("Fetching work order material details by work order ID: {}", workOrderId);
        return mapper.toResponse(dao.findByWorkOrderId(workOrderId));
    }

    @Override
    public List<WorkOrderMaterialDetailsResponse> getByLineItemId(Long lineItemId) {
        log.info("Fetching work order material details by line item ID: {}", lineItemId);
        return mapper.toResponse(dao.findByWoLineItemId(lineItemId));
    }

    @Override
    public List<WorkOrderMaterialDetailsResponse> getAll() {
        log.info("Fetching all work order material details");
        return mapper.toResponse(dao.findAll());
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting work order material detail with ID: {}", id);

        if (!dao.existsById(id)) {
            throw new EntityNotFoundException("Work order material detail not found with ID: " + id);
        }

        dao.deleteById(id);
        log.info("Deleted work order material detail with ID: {}", id);
    }
}
