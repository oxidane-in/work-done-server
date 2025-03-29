package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialManufacturerController;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.material.service.MaterialManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaterialManufacturerControllerImpl implements MaterialManufacturerController {

    private final MaterialManufacturerService materialManufacturerService;

    @Override
    public ResponseEntity<MaterialManufacturerResponse> createMaterialManufacturer(@RequestBody MaterialManufacturerRequest request) {
        MaterialManufacturerResponse response = materialManufacturerService.createMaterialManufacturer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> getMaterialManufacturerById(@PathVariable Long id) {
        MaterialManufacturerResponse response = materialManufacturerService.getMaterialManufacturerById(id);
        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<List<MaterialManufacturerResponse>> getAllMaterialManufacturers() {
        List<MaterialManufacturerResponse> responses = materialManufacturerService.getAllMaterialManufacturers();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<Void> updateMaterialManufacturer(@PathVariable Long id, @RequestBody MaterialManufacturerRequest request) {
        materialManufacturerService.updateMaterialManufacturer(id, request);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteMaterialManufacturer(@PathVariable Long id) {
        materialManufacturerService.deleteMaterialManufacturer(id);
        return ResponseEntity.noContent().build();
    }
}
