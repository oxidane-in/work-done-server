package in.oxidane.work.done.material.service.impl;

import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.material.dao.MaterialManufacturerDao;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.material.mapper.MaterialManufacturerMapper;
import in.oxidane.work.done.material.entity.MaterialManufacturer;
import in.oxidane.work.done.material.service.MaterialManufacturerService;
import in.oxidane.work.done.material.validator.MaterialManufacturerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialManufacturerServiceImpl implements MaterialManufacturerService {

    private final MaterialManufacturerDao materialManufacturerDao;
    private final MaterialManufacturerMapper materialManufacturerMapper;
    private final MaterialManufacturerValidator materialManufacturerValidator;

    @Override
    public MaterialManufacturerResponse createMaterialManufacturer(MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Creating new material manufacturer");
            log.debug("Material manufacturer request: {}", request);

            materialManufacturerValidator.validateForCreate(request);

            MaterialManufacturer materialManufacturer = materialManufacturerMapper.toEntity(request);
            MaterialManufacturer savedMaterialManufacturer = materialManufacturerDao.create(materialManufacturer)
                .orElseThrow(() -> {
                    log.error("Failed to create material manufacturer");
                    return new RuntimeException("Failed to create material manufacturer");
                });

            log.info("Successfully created material manufacturer with id: {}",
                    savedMaterialManufacturer.getMaterialManufacturerId());
            return materialManufacturerMapper.toResponse(savedMaterialManufacturer);
        }
    }

    @Override
    public MaterialManufacturerResponse getMaterialManufacturerById(int id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Fetching material manufacturer with id: {}", id);

            MaterialManufacturer materialManufacturer = materialManufacturerDao.getById(id)
                .orElseThrow(() -> {
                    log.warn("Material manufacturer not found with id: {}", id);
                    return new ResourceNotFoundException("Material manufacturer not found with id: " + id);
                });

            log.debug("Retrieved material manufacturer: {}", materialManufacturer);
            return materialManufacturerMapper.toResponse(materialManufacturer);
        }
    }

    @Override
    public List<MaterialManufacturerResponse> getAllMaterialManufacturers() {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Fetching all material manufacturers");

            List<MaterialManufacturer> materialManufacturers = materialManufacturerDao.getAll();
            log.debug("Retrieved {} material manufacturers", materialManufacturers.size());

            return materialManufacturers.stream()
                .map(materialManufacturerMapper::toResponse)
                .collect(Collectors.toList());
        }
    }

    @Override
    public MaterialManufacturerResponse updateMaterialManufacturer(int id, MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Updating material manufacturer with id: {}", id);
            log.debug("Update request: {}", request);

            materialManufacturerValidator.validateForUpdate(request);

            // Check if the resource exists first
            materialManufacturerDao.getById(id)
                .orElseThrow(() -> {
                    log.warn("Material manufacturer not found with id: {}", id);
                    return new ResourceNotFoundException("Material manufacturer not found with id: " + id);
                });

            // Map request to entity and set the ID
            MaterialManufacturer materialManufacturer = materialManufacturerMapper.toEntity(request)
                .toBuilder()
                .materialManufacturerId(id)
                .build();

            if(materialManufacturerDao.existsById(id)) {
                log.warn("Cannot update - material manufacturer not found with id: {}", id);
                throw new ResourceNotFoundException("Material manufacturer not found with id: " + id);
            }

            // Update and convert response
            MaterialManufacturer updatedMaterialManufacturer = materialManufacturerDao.update(materialManufacturer)
                .orElseThrow(() -> {
                    log.error("Failed to update material manufacturer with id: {}", id);
                    return new RuntimeException("Failed to update material manufacturer");
                });

            log.info("Successfully updated material manufacturer with id: {}", id);
            return materialManufacturerMapper.toResponse(updatedMaterialManufacturer);
        }
    }

    @Override
    public void deleteMaterialManufacturer(int id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Deleting material manufacturer with id: {}", id);

            // Check if the resource exists first
            if(materialManufacturerDao.existsById(id)) {
                log.warn("Cannot delete - material manufacturer not found with id: {}", id);
                throw new ResourceNotFoundException("Material manufacturer not found with id: " + id);
            }

            materialManufacturerDao.delete(id);
            log.info("Successfully deleted material manufacturer with id: {}", id);
        }
    }
}
