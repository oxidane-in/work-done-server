package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.order.dao.MaterialTypeDao;
import in.oxidane.work.done.order.dto.MaterialTypeRequest;
import in.oxidane.work.done.order.dto.MaterialTypeResponse;
import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.mapper.MaterialTypeMapper;
import in.oxidane.work.done.order.model.MaterialType;
import in.oxidane.work.done.order.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialTypeServiceImpl implements MaterialTypeService {

    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeServiceImpl.class);

    private final MaterialTypeDao materialTypeDao;
    private final MaterialTypeMapper materialTypeMapper;

    @Override
    public MaterialTypeResponse createMaterialType(MaterialTypeRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Creating new material type");
            logger.debug("Material type request: {}", request);

            MaterialType materialType = materialTypeMapper.toEntity(request);
            MaterialType savedMaterialType = materialTypeDao.create(materialType)
                .orElseThrow(() -> {
                    logger.error("Failed to create material type");
                    return new RuntimeException("Failed to create material type");
                });

            logger.info("Successfully created material type with id: {}", savedMaterialType.getMaterialTypeId());
            return materialTypeMapper.toResponse(savedMaterialType);
        }
    }

    @Override
    public MaterialTypeResponse getMaterialTypeById(int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Fetching material type with id: {}", id);

            MaterialType materialType = materialTypeDao.getById(id)
                .orElseThrow(() -> {
                    logger.warn("Material type not found with id: {}", id);
                    return new ResourceNotFoundException("Material type not found with id: " + id);
                });

            logger.debug("Retrieved material type: {}", materialType);
            return materialTypeMapper.toResponse(materialType);
        }
    }

    @Override
    public List<MaterialTypeResponse> getAllMaterialTypes() {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Fetching all material types");

            List<MaterialType> materialTypes = materialTypeDao.getAll();
            logger.debug("Retrieved {} material types", materialTypes.size());

            return materialTypes.stream()
                .map(materialTypeMapper::toResponse)
                .collect(Collectors.toList());
        }
    }

    @Override
    public MaterialTypeResponse updateMaterialType(int id, MaterialTypeRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Updating material type with id: {}", id);
            logger.debug("Update request: {}", request);

            // Check if the resource exists first
            materialTypeDao.getById(id)
                .orElseThrow(() -> {
                    logger.warn("Material type not found with id: {}", id);
                    return new ResourceNotFoundException("Material type not found with id: " + id);
                });

            // Map request to entity and set the ID
            MaterialType materialType = materialTypeMapper.toEntity(request).toBuilder().materialTypeId(id).build();

            // Update and convert response
            MaterialType updatedMaterialType = materialTypeDao.update(materialType)
                .orElseThrow(() -> {
                    logger.error("Failed to update material type with id: {}", id);
                    return new RuntimeException("Failed to update material type");
                });

            logger.info("Successfully updated material type with id: {}", id);
            return materialTypeMapper.toResponse(updatedMaterialType);
        }
    }

    @Override
    public void deleteMaterialType(int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Deleting material type with id: {}", id);

            // Check if the resource exists first
            materialTypeDao.getById(id)
                .orElseThrow(() -> {
                    logger.warn("Cannot delete - material type not found with id: {}", id);
                    return new ResourceNotFoundException("Material type not found with id: " + id);
                });

            materialTypeDao.delete(id);
            logger.info("Successfully deleted material type with id: {}", id);
        }
    }
}
