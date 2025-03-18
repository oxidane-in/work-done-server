package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.MaterialDao;
import in.oxidane.work.done.order.entity.Material;
import in.oxidane.work.done.order.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialDao interface.
 * Provides data access operations for the Material entity.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MaterialDaoImpl implements MaterialDao {

    private final MaterialRepository materialRepository;

    @Override
    public Optional<Material> create(Material material) {
        try {
            log.debug("Creating new material: {}", material.getMaterialName());
            Material savedMaterial = materialRepository.save(material);
            log.debug("Successfully created material with ID: {}", savedMaterial.getMaterialId());
            return Optional.of(savedMaterial);
        } catch (Exception e) {
            log.error("Error creating material: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<Material> getById(Integer materialId) {
        log.debug("Fetching material with ID: {}", materialId);
        Optional<Material> material = materialRepository.findById(materialId);
        if (material.isPresent()) {
            log.debug("Found material: {}", material.get().getMaterialName());
        } else {
            log.debug("No material found with ID: {}", materialId);
        }
        return material;
    }

    @Override
    public List<Material> getAll() {
        log.debug("Fetching all materials");
        List<Material> materials = materialRepository.findAll();
        log.debug("Found {} materials", materials.size());
        return materials;
    }

    @Override
    public Optional<Material> update(Integer materialId, Material material) {
        log.debug("Updating material with ID: {}", materialId);
        if (!existsById(materialId)) {
            log.debug("Cannot update - material with ID {} does not exist", materialId);
            return Optional.empty();
        }

        try {
            material.setMaterialId(materialId);
            Material updatedMaterial = materialRepository.save(material);
            log.debug("Successfully updated material: {}", updatedMaterial.getMaterialName());
            return Optional.of(updatedMaterial);
        } catch (Exception e) {
            log.error("Error updating material with ID {}: {}", materialId, e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer materialId) {
        log.debug("Deleting material with ID: {}", materialId);
        if (!existsById(materialId)) {
            log.debug("Cannot delete - material with ID {} does not exist", materialId);
            return false;
        }

        try {
            materialRepository.deleteById(materialId);
            log.debug("Successfully deleted material with ID: {}", materialId);
            return true;
        } catch (Exception e) {
            log.error("Error deleting material with ID {}: {}", materialId, e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean existsById(Integer materialId) {
        boolean exists = materialRepository.existsById(materialId);
        log.debug("Checking if material with ID {} exists: {}", materialId, exists);
        return exists;
    }
}
