package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.UnitOfMeasurementDao;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import in.oxidane.work.done.order.mapper.UnitOfMeasurementMapper;
import in.oxidane.work.done.order.service.UnitOfMeasurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the UnitOfMeasurementService interface.
 * Provides business operations for UnitOfMeasurement entities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UnitOfMeasurementServiceImpl implements UnitOfMeasurementService {

    private final UnitOfMeasurementDao unitOfMeasurementDao;
    private final UnitOfMeasurementMapper unitOfMeasurementMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitOfMeasurementResponse createUnitOfMeasurement(UnitOfMeasurementRequest request) {
        log.info("Creating new unit of measurement");
        log.debug("Unit of measurement request: {}", request);

        UnitOfMeasurement unitOfMeasurement = unitOfMeasurementMapper.toEntity(request);
        UnitOfMeasurement savedUnitOfMeasurement = unitOfMeasurementDao.create(unitOfMeasurement);

        log.info("Successfully created unit of measurement with id: {}", savedUnitOfMeasurement.getUomId());
        return unitOfMeasurementMapper.toResponse(savedUnitOfMeasurement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitOfMeasurementResponse getUnitOfMeasurementById(Long id) {
        log.info("Fetching unit of measurement with id: {}", id);

        UnitOfMeasurement unitOfMeasurement = unitOfMeasurementDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Unit of measurement not found with id: {}", id);
                return new ResourceNotFoundException("Unit of measurement not found with id: " + id);
            });

        log.debug("Retrieved unit of measurement: {}", unitOfMeasurement);
        return unitOfMeasurementMapper.toResponse(unitOfMeasurement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UnitOfMeasurementResponse> getAllUnitsOfMeasurement() {
        log.info("Fetching all units of measurement");

        List<UnitOfMeasurement> unitsOfMeasurement = unitOfMeasurementDao.getAll();
        log.debug("Retrieved {} units of measurement", unitsOfMeasurement.size());

        return unitsOfMeasurement.stream()
            .map(unitOfMeasurementMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitOfMeasurementResponse updateUnitOfMeasurement(Long id, UnitOfMeasurementRequest request) {
        log.info("Updating unit of measurement with id: {}", id);

        UnitOfMeasurement existingUnitOfMeasurement = unitOfMeasurementDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Unit of measurement not found with id: {}", id);
                return new ResourceNotFoundException("Unit of measurement not found with id: " + id);
            });

        // Map request to entity and set the ID
        UnitOfMeasurement unitOfMeasurement = unitOfMeasurementMapper.toUpdateEntityFromRequest(request, existingUnitOfMeasurement);

        log.debug("Update request: {}", unitOfMeasurement.toString());

        // Update and convert response
        UnitOfMeasurement updatedUnitOfMeasurement = unitOfMeasurementDao.update(unitOfMeasurement);

        log.info("Successfully updated unit of measurement with id: {}", id);
        return unitOfMeasurementMapper.toResponse(updatedUnitOfMeasurement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUnitOfMeasurement(Long id) {
        log.info("Deleting unit of measurement with id: {}", id);

        // Check if the resource exists first
        if (!unitOfMeasurementDao.existsById(id)) {
            log.warn("Cannot delete - unit of measurement not found with id: {}", id);
            throw new ResourceNotFoundException("Unit of measurement not found with id: " + id);
        }

        unitOfMeasurementDao.delete(id);
        log.info("Successfully deleted unit of measurement with id: {}", id);
    }
}
