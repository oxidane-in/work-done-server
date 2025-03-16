package in.oxidane.work.done.order.dao.impl;

import in.oxidane.work.done.order.dao.MaterialVendorDao;
import in.oxidane.work.done.order.model.MaterialVendor;
import in.oxidane.work.done.order.repository.MaterialVendorRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the MaterialVendorDao interface.
 * Provides data access operations for the MaterialVendor entity using JPA repository.
 */
@Repository
@RequiredArgsConstructor
public class MaterialVendorDaoImpl implements MaterialVendorDao {

    private static final Logger logger = LoggerFactory.getLogger(MaterialVendorDaoImpl.class);

    private final MaterialVendorRepository materialVendorRepository;

    @Override
    public Optional<MaterialVendor> create(MaterialVendor materialVendor) {
        logger.debug("DAO - Creating material vendor: {}", materialVendor.getMaterialVendorName());
        try {
            MaterialVendor savedVendor = materialVendorRepository.save(materialVendor);
            logger.debug("DAO - Created material vendor with ID: {}", savedVendor.getMaterialVendorId());
            return Optional.of(savedVendor);
        } catch (Exception e) {
            logger.error("DAO - Error creating material vendor: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public Optional<MaterialVendor> getById(int id) {
        logger.debug("DAO - Fetching material vendor with ID: {}", id);
        Optional<MaterialVendor> result = materialVendorRepository.findById(id);
        if (result.isPresent()) {
            logger.debug("DAO - Found material vendor: {}", result.get().getMaterialVendorName());
        } else {
            logger.debug("DAO - Material vendor with ID {} not found", id);
        }
        return result;
    }

    @Override
    public List<MaterialVendor> getAll() {
        logger.debug("DAO - Fetching all material vendors");
        List<MaterialVendor> vendors = materialVendorRepository.findAll();
        logger.debug("DAO - Found {} material vendors", vendors.size());
        return vendors;
    }

    @Override
    public Optional<MaterialVendor> update(MaterialVendor materialVendor) {
        logger.debug("DAO - Updating material vendor with ID: {}", materialVendor.getMaterialVendorId());

        // Check if the entity exists before updating
        if (!materialVendorRepository.existsById(materialVendor.getMaterialVendorId())) {
            logger.debug("DAO - Material vendor with ID {} not found for update", materialVendor.getMaterialVendorId());
            return Optional.empty();
        }

        try {
            MaterialVendor updatedVendor = materialVendorRepository.save(materialVendor);
            logger.debug("DAO - Updated material vendor: {}", updatedVendor.getMaterialVendorName());
            return Optional.of(updatedVendor);
        } catch (Exception e) {
            logger.error("DAO - Error updating material vendor: {}", e.getMessage(), e);
            return Optional.empty();
        }
    }

    @Override
    public void delete(int id) {
        logger.debug("DAO - Deleting material vendor with ID: {}", id);

        // Check if the entity exists before deleting
        if (!materialVendorRepository.existsById(id)) {
            logger.debug("DAO - Material vendor with ID {} not found for deletion", id);
            return;
        }

        try {
            materialVendorRepository.deleteById(id);
            logger.debug("DAO - Deleted material vendor with ID: {}", id);
        } catch (Exception e) {
            logger.error("DAO - Error deleting material vendor: {}", e.getMessage(), e);
        }
    }

    @Override
    public boolean existsById(int id) {
        logger.debug("DAO - Checking if material vendor exists with ID: {}", id);
        boolean exists = materialVendorRepository.existsById(id);
        logger.debug("DAO - Material vendor with ID {} exists: {}", id, exists);
        return exists;
    }
}
