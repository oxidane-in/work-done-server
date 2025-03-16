package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.MaterialManufacturerController;
import in.oxidane.work.done.order.dto.MaterialManufacturerRequest;
import in.oxidane.work.done.order.dto.MaterialManufacturerResponse;
import in.oxidane.work.done.order.service.MaterialManufacturerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/material-manufacturers")
@RequiredArgsConstructor
public class MaterialManufacturerControllerImpl implements MaterialManufacturerController {

    private static final Logger logger = LoggerFactory.getLogger(MaterialManufacturerControllerImpl.class);

    private final MaterialManufacturerService materialManufacturerService;

    @Override
    public ResponseEntity<MaterialManufacturerResponse> create(@RequestBody MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Received request to create material manufacturer");
            logger.debug("Material manufacturer data: {}", request);

            MaterialManufacturerResponse response = materialManufacturerService.create(request);

            logger.info("Created material manufacturer with id: {}", response.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> getById(@PathVariable int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Received request to get material manufacturer by id: {}", id);

            MaterialManufacturerResponse response = materialManufacturerService.getById(id);

            if (response != null) {
                logger.debug("Retrieved material manufacturer: {}", response);

                return ResponseEntity.ok(response);
            } else {
                logger.warn("Null response received for material manufacturer id: {}", id);
                return ResponseEntity.notFound().build();
            }
        }
    }

    @Override
    public ResponseEntity<List<MaterialManufacturerResponse>> getAll() {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Received request to get all material manufacturers");

            List<MaterialManufacturerResponse> responses = materialManufacturerService.getAll();

            logger.debug("Retrieved {} material manufacturers", responses.size());

            return ResponseEntity.ok(responses);
        }
    }

    @Override
    public ResponseEntity<MaterialManufacturerResponse> update(@PathVariable int id, @RequestBody MaterialManufacturerRequest request) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Received request to update material manufacturer with id: {}", id);
            logger.debug("Update data: {}", request);

            MaterialManufacturerResponse response = materialManufacturerService.update(id, request);

            logger.info("Updated material manufacturer with id: {}", response.getId());

            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try (MDC.MDCCloseable closeable = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            logger.info("Received request to delete material manufacturer with id: {}", id);
            materialManufacturerService.delete(id);
            logger.info("Deleted material manufacturer with id: {}", id);
            return ResponseEntity.noContent().build();
        }
    }
}
