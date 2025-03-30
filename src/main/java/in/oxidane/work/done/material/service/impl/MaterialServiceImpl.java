package in.oxidane.work.done.material.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dao.MaterialDao;
import in.oxidane.work.done.material.dao.MaterialManufacturerDao;
import in.oxidane.work.done.material.dao.MaterialTypeDao;
import in.oxidane.work.done.material.dao.MaterialVendorDao;
import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.entity.Material;
import in.oxidane.work.done.material.mapper.MaterialMapper;
import in.oxidane.work.done.material.service.MaterialService;
import in.oxidane.work.done.material.validator.MaterialRequestValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    }

    @Override
    @Transactional(readOnly = true)
    public MaterialResponse getMaterialById(Long materialId) throws ResourceNotFoundException {
        log.info("Retrieving material with ID: {}", materialId);

        return materialDao.getById(materialId)
            .map(materialMapper::toResponse)
            .orElseThrow(() -> {
                log.error("Material not found with ID: {}", materialId);
                return new ResourceNotFoundException("Material not found with ID: " + materialId);
            });
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaterialResponse> getAllMaterials() {
        log.info("Retrieving all materials");

        List<Material> materials = materialDao.getAll();
        log.info("Found {} materials", materials.size());

        return materials.stream()
            .map(materialMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MaterialResponse updateMaterial(Long materialId, MaterialRequest request) throws ResourceNotFoundException {

        //TODO: Check this flow
        log.info("Updating material with ID: {}", materialId);

        // Validate request
        validator.validateForUpdate(request, materialId);

        // Check if material exists
        if (!materialDao.existsById(materialId)) {
            log.error("Material not found with ID: {}", materialId);
            throw new ResourceNotFoundException("Material not found with ID: " + materialId);
        }

//        // Update the material using builder
//        Material updatedMaterial = materialMapper.updateEntityFromRequest(existingMaterial, request);
//        updatedMaterial = setRelatedEntities(updatedMaterial, request);

        // Update the material
        return materialDao.update(materialId, materialMapper.toEntity(request))
            .map(materialMapper::toResponse)
            .orElseThrow(() -> {
                log.error("Failed to update material with ID: {}", materialId);
                return new RuntimeException("Failed to update material");
            });
    }

    @Override
    @Transactional
    public void deleteMaterial(Long materialId) throws ResourceNotFoundException {

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
    }

    /**
     * Sets related entities on the Material entity based on the request.
     *
     * @param material The Material entity to update
     * @param request  The request containing related entity IDs
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
