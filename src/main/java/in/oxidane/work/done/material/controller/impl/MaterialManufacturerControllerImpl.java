package in.oxidane.work.done.material.controller.impl;

import in.oxidane.work.done.material.controller.MaterialManufacturerController;
import in.oxidane.work.done.material.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.material.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.material.service.MaterialManufacturerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MaterialManufacturerControllerImpl implements MaterialManufacturerController {

    private final MaterialManufacturerService materialManufacturerService;

    @Override
    public ResponseEntity<MaterialManufacturerResponse> createMaterialManufacturer(@RequestBody MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Received request to create material manufacturer");
            log.debug("Material manufacturer data: {}", request);

            MaterialManufacturerResponse response = materialManufacturerService.createMaterialManufacturer(request);

            log.info("Created material manufacturer with id: {}", response.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> getMaterialManufacturerById(@PathVariable int id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Received request to get material manufacturer by id: {}", id);

            MaterialManufacturerResponse response = materialManufacturerService.getMaterialManufacturerById(id);

            if (response != null) {
                log.debug("Retrieved material manufacturer: {}", response);

                return ResponseEntity.ok(response);
            } else {
                log.warn("Null response received for material manufacturer id: {}", id);
                return ResponseEntity.notFound().build();
            }
        }
    }

    @Override
    public ResponseEntity<List<MaterialManufacturerResponse>> getAllMaterialManufacturers() {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Received request to get all material manufacturers");

            List<MaterialManufacturerResponse> responses = materialManufacturerService.getAllMaterialManufacturers();

            log.debug("Retrieved {} material manufacturers", responses.size());

            return ResponseEntity.ok(responses);
        }
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> updateMaterialManufacturer(@PathVariable int id, @RequestBody MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Received request to update material manufacturer with id: {}", id);
            log.debug("Update data: {}", request);

            MaterialManufacturerResponse response = materialManufacturerService.updateMaterialManufacturer(id, request);

            log.info("Updated material manufacturer with id: {}", response.getId());

            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<Void> deleteMaterialManufacturer(@PathVariable int id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Received request to delete material manufacturer with id: {}", id);
            materialManufacturerService.deleteMaterialManufacturer(id);
            log.info("Deleted material manufacturer with id: {}", id);
            return ResponseEntity.noContent().build();
        }
    }
}
