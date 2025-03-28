package in.oxidane.work.done.order.controller.impl;

import in.oxidane.work.done.order.controller.UnitOfMeasurementController;
import in.oxidane.work.done.order.dto.UnitOfMeasurementRequest;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import in.oxidane.work.done.order.service.UnitOfMeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the UnitOfMeasurementController interface.
 * Handles HTTP requests related to unit of measurement operations.
 */

@RestController
@RequiredArgsConstructor
public class UnitOfMeasurementControllerImpl implements UnitOfMeasurementController {

    private final UnitOfMeasurementService unitOfMeasurementService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> createUnitOfMeasurement(UnitOfMeasurementRequest request) {
        UnitOfMeasurementResponse response = unitOfMeasurementService.createUnitOfMeasurement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitOfMeasurementResponse> getUnitOfMeasurementById(Long id) {
        UnitOfMeasurementResponse response = unitOfMeasurementService.getUnitOfMeasurementById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<UnitOfMeasurementResponse>> getAllUnitsOfMeasurement() {
        List<UnitOfMeasurementResponse> response = unitOfMeasurementService.getAllUnitsOfMeasurement();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> updateUnitOfMeasurement(Long id, UnitOfMeasurementRequest request) {
        unitOfMeasurementService.updateUnitOfMeasurement(id, request);
        return ResponseEntity.ok().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteUnitOfMeasurement(Long id) {
        unitOfMeasurementService.deleteUnitOfMeasurement(id);
        return ResponseEntity.noContent().build();
    }
}
