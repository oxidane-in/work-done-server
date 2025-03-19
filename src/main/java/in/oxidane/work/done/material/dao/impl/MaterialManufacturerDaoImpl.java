package in.oxidane.work.done.material.dao.impl;

import in.oxidane.work.done.material.dao.MaterialManufacturerDao;
import in.oxidane.work.done.material.entity.MaterialManufacturer;
import in.oxidane.work.done.material.repository.MaterialManufacturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialManufacturerDao interface.
 * Provides data access operations for the MaterialManufacturer entity using JPA repository.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MaterialManufacturerDaoImpl implements MaterialManufacturerDao {

    private final MaterialManufacturerRepository materialManufacturerRepository;

    @Override
    public Optional<MaterialManufacturer> create(MaterialManufacturer materialManufacturer) {
        log.debug("DAO - Creating material manufacturer: {}", materialManufacturer.getMaterialManufacturerName());
        try {
            MaterialManufacturer savedManufacturer = materialManufacturerRepository.save(materialManufacturer);
            log.debug("DAO - Created material manufacturer with ID: {}", savedManufacturer.getMaterialManufacturerId());
            return Optional.of(savedManufacturer);
        } catch (Exception e) {
            log.error("DAO - Error creating material manufacturer: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialManufacturer> getById(int id) {
        log.debug("DAO - Fetching material manufacturer with ID: {}", id);
        Optional<MaterialManufacturer> result = materialManufacturerRepository.findById(id);
        if (result.isPresent()) {
            log.debug("DAO - Found material manufacturer: {}", result.get().getMaterialManufacturerName());
        } else {
            log.debug("DAO - Material manufacturer with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialManufacturer> getAll() {
        log.debug("DAO - Fetching all material manufacturers");
        List<MaterialManufacturer> manufacturers = materialManufacturerRepository.findAll();
        log.debug("DAO - Found {} material manufacturers", manufacturers.size());
        return manufacturers;
    }

    @Override
    public Optional<MaterialManufacturer> update(MaterialManufacturer materialManufacturer) {
        log.debug("DAO - Updating material manufacturer with ID: {}", materialManufacturer.getMaterialManufacturerId());

        // Check if the entity exists before updating
        if (!materialManufacturerRepository.existsById(materialManufacturer.getMaterialManufacturerId())) {
            log.debug("DAO - Material manufacturer with ID {} not found for update", materialManufacturer.getMaterialManufacturerId());
            return Optional.empty();
        }

        try {
            MaterialManufacturer updatedManufacturer = materialManufacturerRepository.save(materialManufacturer);
            log.debug("DAO - Updated material manufacturer: {}", updatedManufacturer.getMaterialManufacturerName());
            return Optional.of(updatedManufacturer);
        } catch (Exception e) {
            log.error("DAO - Error updating material manufacturer: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        log.debug("DAO - Deleting material manufacturer with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialManufacturerRepository.existsById(id)) {
            log.debug("DAO - Material manufacturer with ID {} not found for deletion", id);
            return;
        }

        try {
            materialManufacturerRepository.deleteById(id);
            log.debug("DAO - Deleted material manufacturer with ID: {}", id);
        } catch (Exception e) {
            log.error("DAO - Error deleting material manufacturer: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        log.debug("DAO - Checking if material manufacturer exists with ID: {}", id);
        boolean exists = materialManufacturerRepository.existsById(id);
        log.debug("DAO - Material manufacturer with ID {} exists: {}", id, exists);
        return exists;
    }
}
