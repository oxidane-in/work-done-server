package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.dao.MaterialDao;
import in.oxidane.work.done.order.dao.MaterialManufacturerDao;
import in.oxidane.work.done.order.dao.MaterialTypeDao;
import in.oxidane.work.done.order.dao.MaterialVendorDao;
import in.oxidane.work.done.order.dto.MaterialRequest;
import in.oxidane.work.done.order.dto.MaterialResponse;
import in.oxidane.work.done.order.entity.Material;
import in.oxidane.work.done.order.mapper.MaterialMapper;
import in.oxidane.work.done.order.service.MaterialService;
import in.oxidane.work.done.order.validator.MaterialRequestValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the MaterialService interface.
 * Provides business logic for Material operations.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialDao materialDao;
    private final MaterialManufacturerDao materialManufacturerDao;
    private final MaterialVendorDao materialVendorDao;
    private final MaterialTypeDao materialTypeDao;
    private final MaterialMapper materialMapper;
    private final MaterialRequestValidator validator;

    @Override
    @Transactional
    public MaterialResponse createMaterial(MaterialRequest request) {
        try {
            MDC.put("operation", "createMaterial");
            MDC.put("materialName", request.getMaterialName());

            log.info("Creating new material: {}", request.getMaterialName());

            // Validate request
            validator.validateForCreate(request);

            // Prepare the material entity
            Material material = materialMapper.toEntity(request);
            material = setRelatedEntities(material, request);

            // Save the material
            return materialDao.create(material)
                    .map(materialMapper::toResponse)
                    .orElseThrow(() -> {
                        log.error("Failed to create material: {}", request.getMaterialName());
                        return new RuntimeException("Failed to create material");
                    });
        } finally {
            MDC.remove("operation");
            MDC.remove("materialName");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MaterialResponse getMaterialById(Integer materialId) throws ResourceNotFoundException {
        try {
            MDC.put("operation", "getMaterial");
            MDC.put("materialId", materialId.toString());

            log.info("Retrieving material with ID: {}", materialId);

            return materialDao.getById(materialId)
                    .map(materialMapper::toResponse)
                    .orElseThrow(() -> {
                        log.error("Material not found with ID: {}", materialId);
                        return new ResourceNotFoundException("Material not found with ID: " + materialId);
                    });
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaterialResponse> getAllMaterials() {
        try {
            MDC.put("operation", "getAllMaterials");

            log.info("Retrieving all materials");

            List<Material> materials = materialDao.getAll();
            log.info("Found {} materials", materials.size());

            return materials.stream()
                    .map(materialMapper::toResponse)
                    .collect(Collectors.toList());
        } finally {
            MDC.remove("operation");
        }
    }

    @Override
    @Transactional
    public MaterialResponse updateMaterial(Integer materialId, MaterialRequest request) throws ResourceNotFoundException {
        try {
            MDC.put("operation", "updateMaterial");
            MDC.put("materialId", materialId.toString());
            MDC.put("materialName", request.getMaterialName());

            log.info("Updating material with ID: {}", materialId);

            // Validate request
            validator.validateForUpdate(request, materialId);

            // Check if material exists
            if (!materialDao.existsById(materialId)) {
                log.error("Material not found with ID: {}", materialId);
                throw new ResourceNotFoundException("Material not found with ID: " + materialId);
            }

            // Get the existing material first
            Material existingMaterial = materialDao.getById(materialId)
                    .orElseThrow(() -> new ResourceNotFoundException("Material not found with ID: " + materialId));

            // Update the material using builder
            Material updatedMaterial = materialMapper.updateEntityFromRequest(existingMaterial, request);
            updatedMaterial = setRelatedEntities(updatedMaterial, request);

            // Update the material
            return materialDao.update(materialId, updatedMaterial)
                    .map(materialMapper::toResponse)
                    .orElseThrow(() -> {
                        log.error("Failed to update material with ID: {}", materialId);
                        return new RuntimeException("Failed to update material");
                    });
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
            MDC.remove("materialName");
        }
    }

    @Override
    @Transactional
    public void deleteMaterial(Integer materialId) throws ResourceNotFoundException {
        try {
            MDC.put("operation", "deleteMaterial");
            MDC.put("materialId", materialId.toString());

            log.info("Deleting material with ID: {}", materialId);

            // Check if material exists
            if (!materialDao.existsById(materialId)) {
                log.error("Material not found with ID: {}", materialId);
                throw new ResourceNotFoundException("Material not found with ID: " + materialId);
            }

            // Delete the material
            boolean deleted = materialDao.delete(materialId);
            if (!deleted) {
                log.error("Failed to delete material with ID: {}", materialId);
                throw new RuntimeException("Failed to delete material with ID: " + materialId);
            }

            log.info("Successfully deleted material with ID: {}", materialId);
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
        }
    }

    /**
     * Sets related entities on the Material entity based on the request.
     *
     * @param material The Material entity to update
     * @param request The request containing related entity IDs
     * @return The updated Material entity with related entities set
     */
    private Material setRelatedEntities(Material material, MaterialRequest request) {
        Material.MaterialBuilder builder = material.toBuilder();

        // Set related entities if IDs are provided
        if (request.getMaterialManufacturerId() != null) {
            materialManufacturerDao.getById(request.getMaterialManufacturerId())
                    .ifPresent(builder::materialManufacturer);
        }

        if (request.getMaterialVendorId() != null) {
            materialVendorDao.getById(request.getMaterialVendorId())
                    .ifPresent(builder::materialVendor);
        }

        if (request.getMaterialTypeId() != null) {
            materialTypeDao.getById(request.getMaterialTypeId())
                    .ifPresent(builder::materialType);
        }

        return builder.build();
    }
}
