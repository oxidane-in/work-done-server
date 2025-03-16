package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.MaterialTypeDao;
import in.oxidane.work.done.order.model.MaterialType;
import in.oxidane.work.done.order.repository.MaterialTypeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialTypeDao interface.
 * Provides data access operations for the MaterialType entity using JPA repository.
 */
@Repository
@RequiredArgsConstructor
public class MaterialTypeDaoImpl implements MaterialTypeDao {

    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeDaoImpl.class);

    private final MaterialTypeRepository materialTypeRepository;

    @Override
    public Optional<MaterialType> create(MaterialType materialType) {
        logger.debug("DAO - Creating material type: {}", materialType.getMaterialTypeName());
        try {
            MaterialType savedType = materialTypeRepository.save(materialType);
            logger.debug("DAO - Created material type with ID: {}", savedType.getMaterialTypeId());
            return Optional.of(savedType);
        } catch (Exception e) {
            logger.error("DAO - Error creating material type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialType> getById(int id) {
        logger.debug("DAO - Fetching material type with ID: {}", id);
        Optional<MaterialType> result = materialTypeRepository.findById(id);
        if (result.isPresent()) {
            logger.debug("DAO - Found material type: {}", result.get().getMaterialTypeName());
        } else {
            logger.debug("DAO - Material type with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialType> getAll() {
        logger.debug("DAO - Fetching all material types");
        List<MaterialType> types = materialTypeRepository.findAll();
        logger.debug("DAO - Found {} material types", types.size());
        return types;
    }

    @Override
    public Optional<MaterialType> update(MaterialType materialType) {
        logger.debug("DAO - Updating material type with ID: {}", materialType.getMaterialTypeId());

        // Check if the entity exists before updating
        if (!materialTypeRepository.existsById(materialType.getMaterialTypeId())) {
            logger.debug("DAO - Material type with ID {} not found for update", materialType.getMaterialTypeId());
            return Optional.empty();
        }

        try {
            MaterialType updatedType = materialTypeRepository.save(materialType);
            logger.debug("DAO - Updated material type: {}", updatedType.getMaterialTypeName());
            return Optional.of(updatedType);
        } catch (Exception e) {
            logger.error("DAO - Error updating material type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        logger.debug("DAO - Deleting material type with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialTypeRepository.existsById(id)) {
            logger.debug("DAO - Material type with ID {} not found for deletion", id);
            return;
        }

        try {
            materialTypeRepository.deleteById(id);
            logger.debug("DAO - Deleted material type with ID: {}", id);
        } catch (Exception e) {
            logger.error("DAO - Error deleting material type: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        logger.debug("DAO - Checking if material type exists with ID: {}", id);
        boolean exists = materialTypeRepository.existsById(id);
        logger.debug("DAO - Material type with ID {} exists: {}", id, exists);
        return exists;
    }
}
