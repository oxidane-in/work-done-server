package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialTypeController;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.service.MaterialTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the MaterialTypeController interface.
 * Provides REST API endpoints for managing material types.
 */
@RestController
@RequiredArgsConstructor
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    @Override
    public ResponseEntity<MaterialTypeResponse> createMaterialType(MaterialTypeRequest request) {
        MaterialTypeResponse response = materialTypeService.createMaterialType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> getMaterialTypeById(Long id) {
        MaterialTypeResponse response = materialTypeService.getMaterialTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialTypeResponse>> getAllMaterialTypes() {
        List<MaterialTypeResponse> responses = materialTypeService.getAllMaterialTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialType(Long id, MaterialTypeRequest request) {
        materialTypeService.updateMaterialType(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialType(Long id) {
        materialTypeService.deleteMaterialType(id);
        return ResponseEntity.noContent().build();
    }
}
