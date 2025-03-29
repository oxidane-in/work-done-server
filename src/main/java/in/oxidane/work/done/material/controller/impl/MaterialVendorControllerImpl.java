package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialVendorController;
import in.oxidane.work.done.material.dto.MaterialVendorRequest;
import in.oxidane.work.done.material.dto.MaterialVendorResponse;
import in.oxidane.work.done.material.service.MaterialVendorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the MaterialVendorController Longerface.
 * Provides REST API endpoints for managing material vendors.
 */
@RestController
@RequiredArgsConstructor
public class MaterialVendorControllerImpl implements MaterialVendorController {

    private final MaterialVendorService materialVendorService;

    @Override
    public ResponseEntity<MaterialVendorResponse> createMaterialVendor(@Valid @RequestBody MaterialVendorRequest request) {
        MaterialVendorResponse response = materialVendorService.createMaterialVendor(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MaterialVendorResponse> getMaterialVendorById(@PathVariable Long id) {
        MaterialVendorResponse response = materialVendorService.getMaterialVendorById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<MaterialVendorResponse>> getAllMaterialVendors() {
        List<MaterialVendorResponse> responses = materialVendorService.getAllMaterialVendors();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialVendor(@PathVariable Long id, @Valid @RequestBody MaterialVendorRequest request) {
        materialVendorService.updateMaterialVendor(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialVendor(@PathVariable Long id) {
        materialVendorService.deleteMaterialVendor(id);
        return ResponseEntity.noContent().build();
    }
}
