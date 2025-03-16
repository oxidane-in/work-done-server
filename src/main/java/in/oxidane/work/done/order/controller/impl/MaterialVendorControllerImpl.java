package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.MaterialVendorController;
import in.oxidane.work.done.order.dto.MaterialVendorRequest;
import in.oxidane.work.done.order.dto.MaterialVendorResponse;
import in.oxidane.work.done.order.service.MaterialVendorService;
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

/**
 * Implementation of the MaterialVendorController interface.
 * Provides REST API endpoints for managing material vendors.
 */
@RestController
@RequestMapping("/api/material-vendors")
@RequiredArgsConstructor
public class MaterialVendorControllerImpl implements MaterialVendorController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialVendorControllerImpl.class);

    private final MaterialVendorService materialVendorService;

    @Override
    public ResponseEntity<MaterialVendorResponse> createMaterialVendor(@Valid @RequestBody MaterialVendorRequest request) {
        logger.info("REST request to create a new material vendor");
        logger.debug("Request body: {}", request);

        MaterialVendorResponse response = materialVendorService.createMaterialVendor(request);

        logger.info("Material vendor created with ID: {}", response.getMaterialVendorId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> getMaterialVendorById(@PathVariable int id) {
        logger.info("REST request to get material vendor with ID: {}", id);

        MaterialVendorResponse response = materialVendorService.getMaterialVendorById(id);

        logger.info("Retrieved material vendor: {}", response.getMaterialVendorName());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialVendorResponse>> getAllMaterialVendors() {
        logger.info("REST request to get all material vendors");

        List<MaterialVendorResponse> responses = materialVendorService.getAllMaterialVendors();

        logger.info("Retrieved {} material vendors", responses.size());
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> updateMaterialVendor(@PathVariable int id, @Valid @RequestBody MaterialVendorRequest request) {
        logger.info("REST request to update material vendor with ID: {}", id);
        logger.debug("Request body: {}", request);

        MaterialVendorResponse response = materialVendorService.updateMaterialVendor(id, request);

        logger.info("Updated material vendor with ID: {}", response.getMaterialVendorId());
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteMaterialVendor(@PathVariable int id) {
        logger.info("REST request to delete material vendor with ID: {}", id);

        materialVendorService.deleteMaterialVendor(id);

        logger.info("Deleted material vendor with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
