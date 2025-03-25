package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.UnitOfMeasurementDao;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import in.oxidane.work.done.order.repository.UnitOfMeasurementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UnitOfMeasurementDao interface.
 * Provides data access operations for UnitOfMeasurement entities.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UnitOfMeasurementDaoImpl implements UnitOfMeasurementDao {

    private final UnitOfMeasurementRepository unitOfMeasurementRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<UnitOfMeasurement> getById(Long id) {
        log.debug("Fetching unit of measurement with id: {}", id);
        return unitOfMeasurementRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UnitOfMeasurement> getAll() {
        log.debug("Fetching all units of measurement");
        return unitOfMeasurementRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitOfMeasurement create(UnitOfMeasurement unitOfMeasurement) {
        log.debug("Creating unit of measurement: {}", unitOfMeasurement);
        return unitOfMeasurementRepository.save(unitOfMeasurement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UnitOfMeasurement update(UnitOfMeasurement unitOfMeasurement) {
        log.debug("Updating unit of measurement with id: {}", unitOfMeasurement.getUomId());
        return unitOfMeasurementRepository.save(unitOfMeasurement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        log.debug("Deleting unit of measurement with id: {}", id);
        unitOfMeasurementRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Long id) {
        log.debug("Checking if unit of measurement exists with id: {}", id);
        return unitOfMeasurementRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandle(String handle) {
        log.debug("Checking if unit of measurement exists with handle: {}", handle);
        return unitOfMeasurementRepository.existsByUomHandle(handle);
    }
}
