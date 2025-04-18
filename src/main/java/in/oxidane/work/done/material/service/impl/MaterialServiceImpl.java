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
import in.oxidane.work.done.order.dao.UnitOfMeasurementDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final UnitOfMeasurementDao unitOfMeasurementDao;
    private final MaterialMapper materialMapper;

    @Override
    public MaterialResponse createMaterial(MaterialRequest request) {
        log.info("Creating new material: {}", request.getMaterialName());

        checkAssociatedEntitiesExists(request);

        Material material = materialMapper.toEntity(request);

        return materialDao.create(material)
            .map(materialMapper::toResponse)
            .orElseThrow(() -> {
                log.error("Failed to create material: {}", request.getMaterialName());
                return new RuntimeException("Failed to create material");
            });
    }

    @Override
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
    public List<MaterialResponse> getAllMaterials() {
        log.info("Retrieving all materials");

        List<Material> materials = materialDao.getAll();
        log.info("Found {} materials", materials.size());

        return materialMapper.toResponse(materials);
    }

    @Override
    public void updateMaterial(Long materialId, MaterialRequest request) throws ResourceNotFoundException {

        log.info("Updating material with ID: {}", materialId);

        // Check if material exists
        Material existingMaterial = materialDao.getById(materialId)
            .orElseThrow(() -> {
                log.error("Material not found with ID: {}", materialId);
                return new ResourceNotFoundException("Material not found with ID: " + materialId);
            });

        checkAssociatedEntitiesExists(request);

        // Update the material using builder
        Material updatedMaterial = materialMapper.updateEntityFromRequest(request, existingMaterial);

        materialDao.update(updatedMaterial.getMaterialId(), updatedMaterial);
    }

    @Override
    public void deleteMaterial(Long materialId) throws ResourceNotFoundException {

        log.info("Deleting material with ID: {}", materialId);

        // Check if material exists
        if (!materialDao.existsById(materialId)) {
            log.error("Material not found with ID: {}", materialId);
            throw new ResourceNotFoundException("Material not found with ID: " + materialId);
        }

        materialDao.delete(materialId);

        log.info("Successfully deleted material with ID: {}", materialId);
    }

    /**
     * Sets related entities on the Material entity based on the request.
     *
     * @param request The request containing related entity IDs
     */
    private void checkAssociatedEntitiesExists(MaterialRequest request) {

        Long typeId = request.getMaterialTypeId();
        Long vendorId = request.getMaterialVendorId();
        Long manufacturerId = request.getMaterialManufacturerId();
        Long uomId = request.getMaterialUOMId();

        if (typeId != null && !materialTypeDao.existsById(typeId)) {
            throw new ResourceNotFoundException("MaterialType not found with id " + typeId);
        }

        if (vendorId != null && !materialVendorDao.existsById(vendorId)) {
            throw new ResourceNotFoundException("MaterialVendor not found with id " + vendorId);
        }

        if (manufacturerId != null && !materialManufacturerDao.existsById(manufacturerId)) {
            throw new ResourceNotFoundException("MaterialManufacturer not found with id " + manufacturerId);
        }

        if (uomId != null && !unitOfMeasurementDao.existsById(uomId)) {
            throw new ResourceNotFoundException("UnitOfMeasurement not found with id " + uomId);
        }
    }
}
