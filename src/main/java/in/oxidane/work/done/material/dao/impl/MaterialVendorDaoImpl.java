package in.oxidane.work.done.material.dao.impl;

import in.oxidane.work.done.material.dao.MaterialVendorDao;
import in.oxidane.work.done.material.entity.MaterialVendor;
import in.oxidane.work.done.material.repository.MaterialVendorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialVendorDao interface.
 * Provides data access operations for the MaterialVendor entity using JPA repository.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class MaterialVendorDaoImpl implements MaterialVendorDao {

    private final MaterialVendorRepository materialVendorRepository;

    @Override
    public Optional<MaterialVendor> create(MaterialVendor materialVendor) {
        log.debug("DAO - Creating material vendor: {}", materialVendor.getMaterialVendorName());
        try {
            MaterialVendor savedVendor = materialVendorRepository.save(materialVendor);
            log.debug("DAO - Created material vendor with ID: {}", savedVendor.getMaterialVendorId());
            return Optional.of(savedVendor);
        } catch (Exception e) {
            log.error("DAO - Error creating material vendor: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialVendor> getById(int id) {
        log.debug("DAO - Fetching material vendor with ID: {}", id);
        Optional<MaterialVendor> result = materialVendorRepository.findById(id);
        if (result.isPresent()) {
            log.debug("DAO - Found material vendor: {}", result.get().getMaterialVendorName());
        } else {
            log.debug("DAO - Material vendor with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialVendor> getAll() {
        log.debug("DAO - Fetching all material vendors");
        List<MaterialVendor> vendors = materialVendorRepository.findAll();
        log.debug("DAO - Found {} material vendors", vendors.size());
        return vendors;
    }

    @Override
    public Optional<MaterialVendor> update(MaterialVendor materialVendor) {
        log.debug("DAO - Updating material vendor with ID: {}", materialVendor.getMaterialVendorId());

        // Check if the entity exists before updating
        if (!materialVendorRepository.existsById(materialVendor.getMaterialVendorId())) {
            log.debug("DAO - Material vendor with ID {} not found for update", materialVendor.getMaterialVendorId());
            return Optional.empty();
        }

        try {
            MaterialVendor updatedVendor = materialVendorRepository.save(materialVendor);
            log.debug("DAO - Updated material vendor: {}", updatedVendor.getMaterialVendorName());
            return Optional.of(updatedVendor);
        } catch (Exception e) {
            log.error("DAO - Error updating material vendor: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        log.debug("DAO - Deleting material vendor with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialVendorRepository.existsById(id)) {
            log.debug("DAO - Material vendor with ID {} not found for deletion", id);
            return;
        }

        try {
            materialVendorRepository.deleteById(id);
            log.debug("DAO - Deleted material vendor with ID: {}", id);
        } catch (Exception e) {
            log.error("DAO - Error deleting material vendor: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        log.debug("DAO - Checking if material vendor exists with ID: {}", id);
        boolean exists = materialVendorRepository.existsById(id);
        log.debug("DAO - Material vendor with ID {} exists: {}", id, exists);
        return exists;
    }
}
