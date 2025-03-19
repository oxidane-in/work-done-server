package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialVendorController;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.service.MaterialVendorService;
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
 * Implementation of the MaterialVendorController interface.
 * Provides REST API endpoints for managing material vendors.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/material-vendors")
@RequiredArgsConstructor
public class MaterialVendorControllerImpl implements MaterialVendorController {

    private final MaterialVendorService materialVendorService;

    @Override
    public ResponseEntity<MaterialVendorResponse> createMaterialVendor(@Valid @RequestBody MaterialVendorRequest request) {
        log.info("REST request to create a new material vendor");
        log.debug("Request body: {}", request);

        MaterialVendorResponse response = materialVendorService.createMaterialVendor(request);

        log.info("Material vendor created with ID: {}", response.getMaterialVendorId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> getMaterialVendorById(@PathVariable int id) {
        log.info("REST request to get material vendor with ID: {}", id);

        MaterialVendorResponse response = materialVendorService.getMaterialVendorById(id);

        log.info("Retrieved material vendor: {}", response.getMaterialVendorName());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialVendorResponse>> getAllMaterialVendors() {
        log.info("REST request to get all material vendors");

        List<MaterialVendorResponse> responses = materialVendorService.getAllMaterialVendors();

        log.info("Retrieved {} material vendors", responses.size());
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> updateMaterialVendor(@PathVariable int id, @Valid @RequestBody MaterialVendorRequest request) {
        log.info("REST request to update material vendor with ID: {}", id);
        log.debug("Request body: {}", request);

        MaterialVendorResponse response = materialVendorService.updateMaterialVendor(id, request);

        log.info("Updated material vendor with ID: {}", response.getMaterialVendorId());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteMaterialVendor(@PathVariable int id) {
        log.info("REST request to delete material vendor with ID: {}", id);

        materialVendorService.deleteMaterialVendor(id);

        log.info("Deleted material vendor with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
