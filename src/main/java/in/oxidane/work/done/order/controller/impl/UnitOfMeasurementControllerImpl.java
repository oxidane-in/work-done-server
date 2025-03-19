package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.UnitOfMeasurementController;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.service.UnitOfMeasurementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the UnitOfMeasurementController interface.
 * Handles HTTP requests related to unit of measurement operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UnitOfMeasurementControllerImpl implements UnitOfMeasurementController {

    private final UnitOfMeasurementService unitOfMeasurementService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> createUnitOfMeasurement(UnitOfMeasurementRequest request) {
        log.info("REST request to create unit of measurement");
        UnitOfMeasurementResponse response = unitOfMeasurementService.createUnitOfMeasurement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> getUnitOfMeasurementById(Integer id) {
        log.info("REST request to get unit of measurement with id: {}", id);
        UnitOfMeasurementResponse response = unitOfMeasurementService.getUnitOfMeasurementById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<UnitOfMeasurementResponse>> getAllUnitsOfMeasurement() {
        log.info("REST request to get all units of measurement");
        List<UnitOfMeasurementResponse> response = unitOfMeasurementService.getAllUnitsOfMeasurement();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> updateUnitOfMeasurement(Integer id, UnitOfMeasurementRequest request) {
        log.info("REST request to update unit of measurement with id: {}", id);
        UnitOfMeasurementResponse response = unitOfMeasurementService.updateUnitOfMeasurement(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteUnitOfMeasurement(Integer id) {
        log.info("REST request to delete unit of measurement with id: {}", id);
        unitOfMeasurementService.deleteUnitOfMeasurement(id);
        return ResponseEntity.noContent().build();
    }
} 