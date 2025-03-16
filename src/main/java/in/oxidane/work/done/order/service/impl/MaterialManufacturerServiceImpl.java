package in.oxidane.work.done.order.service.impl;

import in.oxidane.work.done.order.dao.MaterialManufacturerDao;
import in.oxidane.work.done.order.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.order.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.order.mapper.MaterialManufacturerMapper;
import in.oxidane.work.done.order.model.MaterialManufacturer;
import in.oxidane.work.done.order.service.MaterialManufacturerService;
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
public class MaterialManufacturerServiceImpl implements MaterialManufacturerService {

    private static final Logger logger = LoggerFactory.getLogger(MaterialManufacturerServiceImpl.class);

    private final MaterialManufacturerDao materialManufacturerDao;
    private final MaterialManufacturerMapper materialManufacturerMapper;

    @Override
    public MaterialManufacturerResponse create(MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Creating new material manufacturer");
            logger.debug("Material manufacturer request: {}", request);

            MaterialManufacturer materialManufacturer = materialManufacturerMapper.toEntity(request);
            MaterialManufacturer savedMaterialManufacturer = materialManufacturerDao.create(materialManufacturer)
                .orElseThrow(() -> {
                    logger.error("Failed to create material manufacturer");
                    return new RuntimeException("Failed to create material manufacturer");
                });

            logger.info("Successfully created material manufacturer with id: {}",
                    savedMaterialManufacturer.getMaterialManufacturerId());
            return materialManufacturerMapper.toResponse(savedMaterialManufacturer);
        }
    }

    @Override
    public MaterialManufacturerResponse getById(int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Fetching material manufacturer with id: {}", id);

            MaterialManufacturer materialManufacturer = materialManufacturerDao.getById(id)
                .orElseThrow(() -> {
                    logger.warn("Material manufacturer not found with id: {}", id);
                    return new ResourceNotFoundException("Material manufacturer not found with id: " + id);
                });

            logger.debug("Retrieved material manufacturer: {}", materialManufacturer);
            return materialManufacturerMapper.toResponse(materialManufacturer);
        }
    }

    @Override
    public List<MaterialManufacturerResponse> getAll() {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Fetching all material manufacturers");

            List<MaterialManufacturer> materialManufacturers = materialManufacturerDao.getAll();
            logger.debug("Retrieved {} material manufacturers", materialManufacturers.size());

            return materialManufacturers.stream()
                .map(materialManufacturerMapper::toResponse)
                .collect(Collectors.toList());
        }
    }

    @Override
    public MaterialManufacturerResponse update(int id, MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Updating material manufacturer with id: {}", id);
            logger.debug("Update request: {}", request);

            // Check if the resource exists first
            materialManufacturerDao.getById(id)
                .orElseThrow(() -> {
                    logger.warn("Material manufacturer not found with id: {}", id);
                    return new ResourceNotFoundException("Material manufacturer not found with id: " + id);
                });

            // Map request to entity and set the ID
            MaterialManufacturer materialManufacturer = materialManufacturerMapper.toEntity(request)
                .toBuilder()
                .materialManufacturerId(id)
                .build();

            if(materialManufacturerDao.existsById(id)) {
                logger.warn("Cannot update - material manufacturer not found with id: {}", id);
                throw new ResourceNotFoundException("Material manufacturer not found with id: " + id);
            }

            // Update and convert response
            MaterialManufacturer updatedMaterialManufacturer = materialManufacturerDao.update(materialManufacturer)
                .orElseThrow(() -> {
                    logger.error("Failed to update material manufacturer with id: {}", id);
                    return new RuntimeException("Failed to update material manufacturer");
                });

            logger.info("Successfully updated material manufacturer with id: {}", id);
            return materialManufacturerMapper.toResponse(updatedMaterialManufacturer);
        }
    }

    @Override
    public void delete(int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Deleting material manufacturer with id: {}", id);

            // Check if the resource exists first
            if(materialManufacturerDao.existsById(id)) {
                logger.warn("Cannot delete - material manufacturer not found with id: {}", id);
                throw new ResourceNotFoundException("Material manufacturer not found with id: " + id);
            }

            materialManufacturerDao.delete(id);
            logger.info("Successfully deleted material manufacturer with id: {}", id);
        }
    }
}
