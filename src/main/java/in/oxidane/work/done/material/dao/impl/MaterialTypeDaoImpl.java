package in.oxidane.work.done.material.dao.impl;

import in.oxidane.work.done.material.dao.MaterialTypeDao;
import in.oxidane.work.done.material.entity.MaterialType;
import in.oxidane.work.done.material.repository.MaterialTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialTypeDao interface.
 * Provides data access operations for the MaterialType entity using JPA repository.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MaterialTypeDaoImpl implements MaterialTypeDao {

    private final MaterialTypeRepository materialTypeRepository;

    @Override
    public Optional<MaterialType> create(MaterialType materialType) {
        log.debug("DAO - Creating material type: {}", materialType.getMaterialTypeName());
        try {
            MaterialType savedType = materialTypeRepository.save(materialType);
            log.debug("DAO - Created material type with ID: {}", savedType.getMaterialTypeId());
            return Optional.of(savedType);
        } catch (Exception e) {
            log.error("DAO - Error creating material type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialType> getById(int id) {
        log.debug("DAO - Fetching material type with ID: {}", id);
        Optional<MaterialType> result = materialTypeRepository.findById(id);
        if (result.isPresent()) {
            log.debug("DAO - Found material type: {}", result.get().getMaterialTypeName());
        } else {
            log.debug("DAO - Material type with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialType> getAll() {
        log.debug("DAO - Fetching all material types");
        List<MaterialType> types = materialTypeRepository.findAll();
        log.debug("DAO - Found {} material types", types.size());
        return types;
    }

    @Override
    public Optional<MaterialType> update(MaterialType materialType) {
        log.debug("DAO - Updating material type with ID: {}", materialType.getMaterialTypeId());

        // Check if the entity exists before updating
        if (!materialTypeRepository.existsById(materialType.getMaterialTypeId())) {
            log.debug("DAO - Material type with ID {} not found for update", materialType.getMaterialTypeId());
            return Optional.empty();
        }

        try {
            MaterialType updatedType = materialTypeRepository.save(materialType);
            log.debug("DAO - Updated material type: {}", updatedType.getMaterialTypeName());
            return Optional.of(updatedType);
        } catch (Exception e) {
            log.error("DAO - Error updating material type: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        log.debug("DAO - Deleting material type with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialTypeRepository.existsById(id)) {
            log.debug("DAO - Material type with ID {} not found for deletion", id);
            return;
        }

        try {
            materialTypeRepository.deleteById(id);
            log.debug("DAO - Deleted material type with ID: {}", id);
        } catch (Exception e) {
            log.error("DAO - Error deleting material type: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        log.debug("DAO - Checking if material type exists with ID: {}", id);
        boolean exists = materialTypeRepository.existsById(id);
        log.debug("DAO - Material type with ID {} exists: {}", id, exists);
        return exists;
    }
}
