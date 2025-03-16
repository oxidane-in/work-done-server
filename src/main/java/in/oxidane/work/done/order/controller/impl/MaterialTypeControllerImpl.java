package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.MaterialTypeController;
import in.oxidane.work.done.order.dto.MaterialTypeRequest;
import in.oxidane.work.done.order.dto.MaterialTypeResponse;
import in.oxidane.work.done.order.service.MaterialTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/material-types")
@RequiredArgsConstructor
public class MaterialTypeControllerImpl implements MaterialTypeController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeControllerImpl.class);

    private final MaterialTypeService materialTypeService;

    @Override
    public ResponseEntity<MaterialTypeResponse> create(@Valid @RequestBody MaterialTypeRequest request) {
        logger.info("REST request to create a new material type");

        MaterialTypeResponse response = materialTypeService.createMaterialType(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> getById(@PathVariable int id) {
        logger.info("REST request to get material type with ID: {}", id);

        MaterialTypeResponse response = materialTypeService.getMaterialTypeById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialTypeResponse>> getAll() {
        logger.info("REST request to get all material types");

        List<MaterialTypeResponse> responses = materialTypeService.getAllMaterialTypes();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<MaterialTypeResponse> update(@PathVariable int id, @Valid @RequestBody MaterialTypeRequest request) {
        logger.info("REST request to update material type with ID: {}", id);

        MaterialTypeResponse response = materialTypeService.updateMaterialType(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable int id) {
        logger.info("REST request to delete material type with ID: {}", id);

        materialTypeService.deleteMaterialType(id);
        return ResponseEntity.noContent().build();
    }
}
