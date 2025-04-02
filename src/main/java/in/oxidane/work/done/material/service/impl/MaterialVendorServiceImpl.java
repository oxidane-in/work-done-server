package in.oxidane.work.done.material.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dao.MaterialVendorDao;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.entity.MaterialVendor;
import in.oxidane.work.done.material.mapper.MaterialVendorMapper;
import in.oxidane.work.done.material.service.MaterialVendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the MaterialVendorService interface.
 * Provides business logic for MaterialVendor operations using the DAO layer.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialVendorServiceImpl implements MaterialVendorService {

    private final MaterialVendorDao materialVendorDao;
    private final MaterialVendorMapper materialVendorMapper;

    @Override
    public MaterialVendorResponse createMaterialVendor(MaterialVendorRequest request) {
        log.info("Creating new material vendor: {}", request.getMaterialVendorName());
        log.debug("Material vendor request details: {}", request);

        MaterialVendor materialVendor = materialVendorMapper.toEntity(request);

        MaterialVendor savedVendor = materialVendorDao.create(materialVendor)
            .orElseThrow(() -> {
                log.error("Failed to create material vendor");
                return new RuntimeException("Failed to create material vendor");
            });

        log.info("Material vendor created successfully with ID: {}", savedVendor.getMaterialVendorId());
        log.debug("Created material vendor details: {}", savedVendor);

        return materialVendorMapper.toResponse(savedVendor);
    }

    @Override
    public MaterialVendorResponse getMaterialVendorById(Long id) {
        log.info("Fetching material vendor with ID: {}", id);

        MaterialVendor materialVendor = materialVendorDao.getById(id)
            .orElseThrow(() -> {
                log.info("Material vendor not found with ID: {}", id);
                return new ResourceNotFoundException("Material vendor not found with ID: " + id);
            });

        log.info("Found material vendor: {}", materialVendor.getMaterialVendorName());
        log.debug("Material vendor details: {}", materialVendor);

        return materialVendorMapper.toResponse(materialVendor);
    }

    @Override
    public List<MaterialVendorResponse> getAllMaterialVendors() {
        log.info("Fetching all material vendors");

        List<MaterialVendor> vendors = materialVendorDao.getAll();
        log.info("Found {} material vendors", vendors.size());
        log.debug("Material vendors details: {}", vendors);

        return vendors.stream()
            .map(materialVendorMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public MaterialVendorResponse updateMaterialVendor(Long id, MaterialVendorRequest request) {
        log.info("Updating material vendor with ID: {}", id);

        // Check if the resource exists first
        MaterialVendor existingMaterialVendor = materialVendorDao.getById(id)
            .orElseThrow(() -> {
                log.info("Material vendor not found with ID: {}", id);
                return new ResourceNotFoundException("Material vendor not found with ID: " + id);
            });

        MaterialVendor materialVendor = materialVendorMapper.toUpdateEntityFromRequest(request, existingMaterialVendor);

        log.debug("Updating material vendor: {}", materialVendor);

        // Update the entity
        MaterialVendor updatedVendor = materialVendorDao.update(materialVendor)
            .orElseThrow(() -> {
                log.error("Failed to update material vendor with ID: {}", id);
                return new RuntimeException("Failed to update material vendor with ID: " + id);
            });

        log.info("Material vendor updated successfully with ID: {}", id);
        return materialVendorMapper.toResponse(updatedVendor);
    }

    @Override
    public void deleteMaterialVendor(Long id) {
        log.info("Deleting material vendor with ID: {}", id);

        // Check if entity exists
        if (!materialVendorDao.existsById(id)) {
            log.info("Material vendor not found with ID: {}", id);
            throw new ResourceNotFoundException("Material vendor not found with ID: " + id);
        }

        materialVendorDao.delete(id);
        log.info("Material vendor deleted successfully with ID: {}", id);
    }
}
