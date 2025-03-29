package in.oxidane.work.done.material.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dao.MaterialTypeDao;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.entity.MaterialType;
import in.oxidane.work.done.material.mapper.MaterialTypeMapper;
import in.oxidane.work.done.material.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the MaterialTypeService interface.
 * Provides business logic for MaterialType operations using the DAO layer.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialTypeServiceImpl implements MaterialTypeService {

    private final MaterialTypeDao materialTypeDao;
    private final MaterialTypeMapper materialTypeMapper;

    @Override
    public MaterialTypeResponse createMaterialType(MaterialTypeRequest request) {
        log.info("Creating new material type");
        log.debug("Material type request: {}", request);

        MaterialType materialType = materialTypeMapper.toEntity(request);
        MaterialType savedMaterialType = materialTypeDao.create(materialType)
            .orElseThrow(() -> {
                log.error("Failed to create material type");
                return new RuntimeException("Failed to create material type");
            });

        log.info("Successfully created material type with id: {}", savedMaterialType.getMaterialTypeId());
        return materialTypeMapper.toResponse(savedMaterialType);
    }

    @Override
    public MaterialTypeResponse getMaterialTypeById(Long id) {
        log.info("Fetching material type with id: {}", id);

        MaterialType materialType = materialTypeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Material type not found with id: {}", id);
                return new ResourceNotFoundException("Material type not found with id: " + id);
            });

        log.debug("Retrieved material type: {}", materialType);
        return materialTypeMapper.toResponse(materialType);
    }

    @Override
    public List<MaterialTypeResponse> getAllMaterialTypes() {
        log.info("Fetching all material types");

        List<MaterialType> materialTypes = materialTypeDao.getAll();
        log.debug("Retrieved {} material types", materialTypes.size());

        return materialTypes.stream()
            .map(materialTypeMapper::toResponse)
            .collect(Collectors.toList());
    }

    @Override
    public MaterialTypeResponse updateMaterialType(Long id, MaterialTypeRequest request) {
        log.info("Updating material type with id: {}", id);

        // Check if the resource exists first
        MaterialType existingMaterialType = materialTypeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Material type not found with id: {}", id);
                return new ResourceNotFoundException("Material type not found with id: " + id);
            });

        // Map request to entity and set the ID
        MaterialType materialType = materialTypeMapper.toUpdateEntityFromRequest(request, existingMaterialType);

        log.debug("Updating material type: {}", materialType);

        // Update and convert response
        MaterialType updatedMaterialType = materialTypeDao.update(materialType)
            .orElseThrow(() -> {
                log.error("Failed to update material type with id: {}", id);
                return new RuntimeException("Failed to update material type");
            });

        log.info("Successfully updated material type with id: {}", id);
        return materialTypeMapper.toResponse(updatedMaterialType);

    }

    @Override
    public void deleteMaterialType(Long id) {
        log.info("Deleting material type with id: {}", id);

        // Check if the resource exists first
        materialTypeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Cannot delete - material type not found with id: {}", id);
                return new ResourceNotFoundException("Material type not found with id: " + id);
            });

        materialTypeDao.delete(id);
        log.info("Successfully deleted material type with id: {}", id);

    }
}
