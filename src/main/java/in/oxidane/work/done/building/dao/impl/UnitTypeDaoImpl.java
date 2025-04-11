package in.oxidane.work.done.building.dao.impl;

import in.oxidane.work.done.building.dao.UnitTypeDao;
import in.oxidane.work.done.building.entity.UnitType;
import in.oxidane.work.done.building.repository.UnitTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UnitTypeDao interface.
 * Provides data access operations for UnitType entities.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UnitTypeDaoImpl implements UnitTypeDao {

    private final UnitTypeRepository unitTypeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<UnitType> getById(Long id) {
        log.debug("Fetching unit type with id: {}", id);
        return unitTypeRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UnitType> getAll() {
        log.debug("Fetching all unit types");
        return unitTypeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitType create(UnitType unitType) {
        log.debug("Creating unit type: {}", unitType.toString());
        return unitTypeRepository.save(unitType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitType update(UnitType unitType) {
        log.debug("Updating unit type: {}", unitType);
        return unitTypeRepository.save(unitType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        log.debug("Deleting unit type with id: {}", id);
        unitTypeRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Long id) {
        log.debug("Checking if unit type exists with id: {}", id);
        return unitTypeRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandle(String handle) {
        log.debug("Checking if unit type exists with handle: {}", handle);
        return unitTypeRepository.existsByUnitTypeHandle(handle);
    }
}
