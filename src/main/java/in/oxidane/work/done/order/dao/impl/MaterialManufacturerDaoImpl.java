package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.MaterialManufacturerDao;
import in.oxidane.work.done.order.model.MaterialManufacturer;
import in.oxidane.work.done.order.repository.MaterialManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialManufacturerDao interface.
 * Provides data access operations for the MaterialManufacturer entity using JPA repository.
 */
@Repository
@RequiredArgsConstructor
public class MaterialManufacturerDaoImpl implements MaterialManufacturerDao {

    private static final Logger logger = LoggerFactory.getLogger(MaterialManufacturerDaoImpl.class);

    private final MaterialManufacturerRepository materialManufacturerRepository;

    @Override
    public Optional<MaterialManufacturer> create(MaterialManufacturer materialManufacturer) {
        logger.debug("DAO - Creating material manufacturer: {}", materialManufacturer.getMaterialManufacturerName());
        try {
            MaterialManufacturer savedManufacturer = materialManufacturerRepository.save(materialManufacturer);
            logger.debug("DAO - Created material manufacturer with ID: {}", savedManufacturer.getMaterialManufacturerId());
            return Optional.of(savedManufacturer);
        } catch (Exception e) {
            logger.error("DAO - Error creating material manufacturer: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialManufacturer> getById(int id) {
        logger.debug("DAO - Fetching material manufacturer with ID: {}", id);
        Optional<MaterialManufacturer> result = materialManufacturerRepository.findById(id);
        if (result.isPresent()) {
            logger.debug("DAO - Found material manufacturer: {}", result.get().getMaterialManufacturerName());
        } else {
            logger.debug("DAO - Material manufacturer with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialManufacturer> getAll() {
        logger.debug("DAO - Fetching all material manufacturers");
        List<MaterialManufacturer> manufacturers = materialManufacturerRepository.findAll();
        logger.debug("DAO - Found {} material manufacturers", manufacturers.size());
        return manufacturers;
    }

    @Override
    public Optional<MaterialManufacturer> update(MaterialManufacturer materialManufacturer) {
        logger.debug("DAO - Updating material manufacturer with ID: {}", materialManufacturer.getMaterialManufacturerId());

        // Check if the entity exists before updating
        if (!materialManufacturerRepository.existsById(materialManufacturer.getMaterialManufacturerId())) {
            logger.debug("DAO - Material manufacturer with ID {} not found for update", materialManufacturer.getMaterialManufacturerId());
            return Optional.empty();
        }

        try {
            MaterialManufacturer updatedManufacturer = materialManufacturerRepository.save(materialManufacturer);
            logger.debug("DAO - Updated material manufacturer: {}", updatedManufacturer.getMaterialManufacturerName());
            return Optional.of(updatedManufacturer);
        } catch (Exception e) {
            logger.error("DAO - Error updating material manufacturer: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        logger.debug("DAO - Deleting material manufacturer with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialManufacturerRepository.existsById(id)) {
            logger.debug("DAO - Material manufacturer with ID {} not found for deletion", id);
            return;
        }

        try {
            materialManufacturerRepository.deleteById(id);
            logger.debug("DAO - Deleted material manufacturer with ID: {}", id);
        } catch (Exception e) {
            logger.error("DAO - Error deleting material manufacturer: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        logger.debug("DAO - Checking if material manufacturer exists with ID: {}", id);
        boolean exists = materialManufacturerRepository.existsById(id);
        logger.debug("DAO - Material manufacturer with ID {} exists: {}", id, exists);
        return exists;
    }
}
