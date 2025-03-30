package in.oxidane.work.done.building.service.impl;

import in.oxidane.work.done.building.dao.UnitTypeDao;
import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;
import in.oxidane.work.done.building.entity.UnitType;
import in.oxidane.work.done.building.mapper.UnitTypeMapper;
import in.oxidane.work.done.building.service.UnitTypeService;
import in.oxidane.work.done.building.validator.UnitTypeValidator;
import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the UnitTypeService interface.
 * Provides business operations for UnitType entities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UnitTypeServiceImpl implements UnitTypeService {

    private final UnitTypeDao unitTypeDao;
    private final UnitTypeMapper unitTypeMapper;
    private final UnitTypeValidator unitTypeValidator;

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitTypeResponse createUnitType(UnitTypeRequest request) {
        log.info("Creating new unit type");
        log.debug("Unit type request: {}", request);

        unitTypeValidator.validateForCreate(request);

        UnitType unitType = unitTypeMapper.toEntity(request);
        UnitType savedUnitType = unitTypeDao.create(unitType);

        log.info("Successfully created unit type with id: {}", savedUnitType.getUnitTypeId());
        return unitTypeMapper.toResponse(savedUnitType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitTypeResponse getUnitTypeById(Long id) {
        log.info("Fetching unit type with id: {}", id);

        UnitType unitType = unitTypeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Unit type not found with id: {}", id);
                return new ResourceNotFoundException("Unit type not found with id: " + id);
            });

        log.debug("Retrieved unit type: {}", unitType);
        return unitTypeMapper.toResponse(unitType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UnitTypeResponse> getAllUnitTypes() {
        log.info("Fetching all unit types");

        List<UnitType> unitTypes = unitTypeDao.getAll();
        log.debug("Retrieved {} unit types", unitTypes.size());

        return unitTypes.stream()
            .map(unitTypeMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitTypeResponse updateUnitType(Long id, UnitTypeRequest request) {
        log.info("Updating unit type with id: {}", id);
        log.debug("Update request: {}", request);

        UnitType existingUnitType = unitTypeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Unit type not found with id: {}", id);
                return new ResourceNotFoundException("Unit type not found with id: " + id);
            });

        log.debug("Existing unit type: {}", existingUnitType);

        // Map request to entity and set the ID
        UnitType unitType = unitTypeMapper.updateEntityFromDto(request, existingUnitType);

        // Update and convert response
        UnitType updatedUnitType = unitTypeDao.update(unitType);

        log.info("Successfully updated unit type: {}", updatedUnitType.toString());
        return unitTypeMapper.toResponse(updatedUnitType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUnitType(Long id) {
        log.info("Deleting unit type with id: {}", id);

        // Check if the resource exists first
        if (!unitTypeDao.existsById(id)) {
            log.warn("Cannot delete - unit type not found with id: {}", id);
            throw new ResourceNotFoundException("Unit type not found with id: " + id);
        }

        unitTypeDao.delete(id);
        log.info("Successfully deleted unit type with id: {}", id);
    }
}
