package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.MaterialController;
import in.oxidane.work.done.order.dto.MaterialRequest;
import in.oxidane.work.done.order.dto.MaterialResponse;
import in.oxidane.work.done.order.service.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the MaterialController interface.
 * Provides REST endpoints for Material operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;

    @Override
    public ResponseEntity<MaterialResponse> createMaterial(MaterialRequest request) {
        try {
            MDC.put("operation", "createMaterial");
            MDC.put("materialName", request.getMaterialName());

            log.info("API call to create material: {}", request.getMaterialName());
            MaterialResponse response = materialService.createMaterial(request);
            log.info("Material created successfully with ID: {}", response.getMaterialId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } finally {
            MDC.remove("operation");
            MDC.remove("materialName");
        }
    }

    @Override
    public ResponseEntity<MaterialResponse> getMaterialById(Integer materialId) {
        try {
            MDC.put("operation", "getMaterialById");
            MDC.put("materialId", materialId.toString());

            log.info("API call to get material with ID: {}", materialId);
            MaterialResponse response = materialService.getMaterialById(materialId);
            log.info("Retrieved material: {}", response.getMaterialName());

            return ResponseEntity.ok(response);
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
        }
    }

    @Override
    public ResponseEntity<List<MaterialResponse>> getAllMaterials() {
        try {
            MDC.put("operation", "getAllMaterials");

            log.info("API call to get all materials");
            List<MaterialResponse> materials = materialService.getAllMaterials();
            log.info("Retrieved {} materials", materials.size());

            return ResponseEntity.ok(materials);
        } finally {
            MDC.remove("operation");
        }
    }

    @Override
    public ResponseEntity<MaterialResponse> updateMaterial(Integer materialId, MaterialRequest request) {
        try {
            MDC.put("operation", "updateMaterial");
            MDC.put("materialId", materialId.toString());
            MDC.put("materialName", request.getMaterialName());

            log.info("API call to update material with ID: {}", materialId);
            MaterialResponse response = materialService.updateMaterial(materialId, request);
            log.info("Material updated successfully: {}", response.getMaterialName());

            return ResponseEntity.ok(response);
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
            MDC.remove("materialName");
        }
    }

    @Override
    public ResponseEntity<Void> deleteMaterial(Integer materialId) {
        try {
            MDC.put("operation", "deleteMaterial");
            MDC.put("materialId", materialId.toString());

            log.info("API call to deleteMaterial material with ID: {}", materialId);
            materialService.deleteMaterial(materialId);
            log.info("Material deleted successfully");

            return ResponseEntity.noContent().build();
        } finally {
            MDC.remove("operation");
            MDC.remove("materialId");
        }
    }
}
