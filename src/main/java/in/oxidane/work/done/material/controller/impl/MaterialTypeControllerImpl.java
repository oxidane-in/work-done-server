package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialTypeController;
import in.oxidane.work.done.material.dto.MaterialTypeRequest;
import in.oxidane.work.done.material.dto.MaterialTypeResponse;
import in.oxidane.work.done.material.service.MaterialTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the MaterialTypeController interface.
 * Provides REST API endpoints for managing material types.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/material-types")
@RequiredArgsConstructor
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private final MaterialTypeService materialTypeService;

    @Override
    public ResponseEntity<MaterialTypeResponse> createMaterialType(@Valid @RequestBody MaterialTypeRequest request) {
        log.info("REST request to create a new material type");

        MaterialTypeResponse response = materialTypeService.createMaterialType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> getMaterialTypeById(@PathVariable int id) {
        log.info("REST request to get material type with ID: {}", id);

        MaterialTypeResponse response = materialTypeService.getMaterialTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialTypeResponse>> getAllMaterialTypes() {
        log.info("REST request to get all material types");

        List<MaterialTypeResponse> responses = materialTypeService.getAllMaterialTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> updateMaterialType(@PathVariable int id, @Valid @RequestBody MaterialTypeRequest request) {
        log.info("REST request to update material type with ID: {}", id);

        MaterialTypeResponse response = materialTypeService.updateMaterialType(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteMaterialType(@PathVariable int id) {
        log.info("REST request to delete material type with ID: {}", id);

        materialTypeService.deleteMaterialType(id);
        return ResponseEntity.noContent().build();
    }
}
