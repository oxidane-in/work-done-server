package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialController;
import in.oxidane.work.done.material.dto.MaterialRequest;
import in.oxidane.work.done.material.dto.MaterialResponse;
import in.oxidane.work.done.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the MaterialController interface.
 * Provides REST endpoints for Material operations.
 */
@RestController
@RequiredArgsConstructor
public class MaterialControllerImpl implements MaterialController {

    private final MaterialService materialService;

    @Override
    public ResponseEntity<MaterialResponse> createMaterial(MaterialRequest request) {
        MaterialResponse response = materialService.createMaterial(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<MaterialResponse> getMaterialById(Long materialId) {
        MaterialResponse response = materialService.getMaterialById(materialId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialResponse>> getAllMaterials() {
        List<MaterialResponse> materials = materialService.getAllMaterials();
        return ResponseEntity.ok(materials);
    }

    @Override
    public ResponseEntity<MaterialResponse> updateMaterial(Long materialId, MaterialRequest request) {
        MaterialResponse response = materialService.updateMaterial(materialId, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteMaterial(Long materialId) {
        materialService.deleteMaterial(materialId);
        return ResponseEntity.noContent().build();
    }
}

