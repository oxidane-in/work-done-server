package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.MaterialVendorDao;
import in.oxidane.work.done.order.dto.MaterialVendorRequest;
import in.oxidane.work.done.order.dto.MaterialVendorResponse;
import in.oxidane.work.done.order.mapper.MaterialVendorMapper;
import in.oxidane.work.done.order.model.MaterialVendor;
import in.oxidane.work.done.order.service.MaterialVendorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the MaterialVendorService interface.
 * Provides business logic for MaterialVendor operations using the DAO layer.
 */
@Service
@RequiredArgsConstructor
public class MaterialVendorServiceImpl implements MaterialVendorService {

    private static final Logger logger = LoggerFactory.getLogger(MaterialVendorServiceImpl.class);

    private final MaterialVendorDao materialVendorDao;
    private final MaterialVendorMapper materialVendorMapper;

    @Override
    @Transactional
    public MaterialVendorResponse createMaterialVendor(MaterialVendorRequest request) {
        logger.info("Creating new material vendor: {}", request.getMaterialVendorName());
        logger.debug("Material vendor request details: {}", request);

        MaterialVendor materialVendor = materialVendorMapper.toEntity(request);

        MaterialVendor savedVendor = materialVendorDao.create(materialVendor)
                .orElseThrow(() -> {
                    logger.error("Failed to create material vendor");
                    return new RuntimeException("Failed to create material vendor");
                });

        logger.info("Material vendor created successfully with ID: {}", savedVendor.getMaterialVendorId());
        logger.debug("Created material vendor details: {}", savedVendor);

        return materialVendorMapper.toResponse(savedVendor);
    }

    @Override
    @Transactional(readOnly = true)
    public MaterialVendorResponse getMaterialVendorById(int id) {
        logger.info("Fetching material vendor with ID: {}", id);

        MaterialVendor materialVendor = materialVendorDao.getById(id)
                .orElseThrow(() -> {
                    logger.info("Material vendor not found with ID: {}", id);
                    return new ResourceNotFoundException("Material vendor not found with ID: " + id);
                });

        logger.info("Found material vendor: {}", materialVendor.getMaterialVendorName());
        logger.debug("Material vendor details: {}", materialVendor);

        return materialVendorMapper.toResponse(materialVendor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaterialVendorResponse> getAllMaterialVendors() {
        logger.info("Fetching all material vendors");

        List<MaterialVendor> vendors = materialVendorDao.getAll();
        logger.info("Found {} material vendors", vendors.size());
        logger.debug("Material vendors details: {}", vendors);

        return vendors.stream()
                .map(materialVendorMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MaterialVendorResponse updateMaterialVendor(int id, MaterialVendorRequest request) {
        logger.info("Updating material vendor with ID: {}", id);
        logger.debug("Update request details: {}", request);

        // Check if entity exists
        if (!materialVendorDao.existsById(id)) {
            logger.info("Material vendor not found with ID: {}", id);
            throw new ResourceNotFoundException("Material vendor not found with ID: " + id);
        }

        // Create entity from request and set the ID
        MaterialVendor materialVendor = materialVendorMapper.toEntity(request);
        materialVendor.setMaterialVendorId(id);

        // Update the entity
        MaterialVendor updatedVendor = materialVendorDao.update(materialVendor)
                .orElseThrow(() -> {
                    logger.error("Failed to update material vendor with ID: {}", id);
                    return new RuntimeException("Failed to update material vendor with ID: " + id);
                });

        logger.info("Material vendor updated successfully with ID: {}", id);
        logger.debug("Updated material vendor details: {}", updatedVendor);

        return materialVendorMapper.toResponse(updatedVendor);
    }

    @Override
    @Transactional
    public void deleteMaterialVendor(int id) {
        logger.info("Deleting material vendor with ID: {}", id);

        // Check if entity exists
        if (!materialVendorDao.existsById(id)) {
            logger.info("Material vendor not found with ID: {}", id);
            throw new ResourceNotFoundException("Material vendor not found with ID: " + id);
        }

        materialVendorDao.delete(id);
        logger.info("Material vendor deleted successfully with ID: {}", id);
    }
}
