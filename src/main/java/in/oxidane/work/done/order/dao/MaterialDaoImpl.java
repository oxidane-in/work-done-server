package in.oxidane.work.done.order.dao;

import in.oxidane.work.done.order.model.Material;
import in.oxidane.work.done.order.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialDao interface.
 * Provides data access operations for the Material entity.
 */
@Repository
public class MaterialDaoImpl implements MaterialDao {

    private static final Logger logger = LoggerFactory.getLogger(MaterialDaoImpl.class);
    private final MaterialRepository materialRepository;

    public MaterialDaoImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Optional<Material> create(Material material) {
        try {
            logger.debug("Creating new material: {}", material.getMaterialName());
            Material savedMaterial = materialRepository.save(material);
            logger.debug("Successfully created material with ID: {}", savedMaterial.getMaterialId());
            return Optional.of(savedMaterial);
        } catch (Exception e) {
            logger.error("Error creating material: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Material> getById(Integer materialId) {
        logger.debug("Fetching material with ID: {}", materialId);
        Optional<Material> material = materialRepository.findById(materialId);
        if (material.isPresent()) {
            logger.debug("Found material: {}", material.get().getMaterialName());
        } else {
            logger.debug("No material found with ID: {}", materialId);
        }
        return material;
    }

    @Override
    public List<Material> getAll() {
        logger.debug("Fetching all materials");
        List<Material> materials = materialRepository.findAll();
        logger.debug("Found {} materials", materials.size());
        return materials;
    }

    @Override
    public Optional<Material> update(Integer materialId, Material material) {
        logger.debug("Updating material with ID: {}", materialId);
        if (!existsById(materialId)) {
            logger.debug("Cannot update - material with ID {} does not exist", materialId);
            return Optional.empty();
        }
        
        try {
            material.setMaterialId(materialId);
            Material updatedMaterial = materialRepository.save(material);
            logger.debug("Successfully updated material: {}", updatedMaterial.getMaterialName());
            return Optional.of(updatedMaterial);
        } catch (Exception e) {
            logger.error("Error updating material with ID {}: {}", materialId, e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer materialId) {
        logger.debug("Deleting material with ID: {}", materialId);
        if (!existsById(materialId)) {
            logger.debug("Cannot delete - material with ID {} does not exist", materialId);
            return false;
        }
        
        try {
            materialRepository.deleteById(materialId);
            logger.debug("Successfully deleted material with ID: {}", materialId);
            return true;
        } catch (Exception e) {
            logger.error("Error deleting material with ID {}: {}", materialId, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean existsById(Integer materialId) {
        boolean exists = materialRepository.existsById(materialId);
        logger.debug("Checking if material with ID {} exists: {}", materialId, exists);
        return exists;
    }
} 