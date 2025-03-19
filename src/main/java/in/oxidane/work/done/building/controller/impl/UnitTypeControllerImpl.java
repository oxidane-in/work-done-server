package in.oxidane.work.done.building.controller.impl;

import in.oxidane.work.done.building.controller.UnitTypeController;
import in.oxidane.work.done.building.dto.UnitTypeRequest;
import in.oxidane.work.done.building.dto.UnitTypeResponse;
import in.oxidane.work.done.building.service.UnitTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the UnitTypeController interface.
 * Handles HTTP requests related to unit type operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UnitTypeControllerImpl implements UnitTypeController {

    private final UnitTypeService unitTypeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitTypeResponse> createUnitType(UnitTypeRequest request) {
        log.info("REST request to create unit type");
        UnitTypeResponse response = unitTypeService.createUnitType(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitTypeResponse> getUnitTypeById(Integer id) {
        log.info("REST request to get unit type with id: {}", id);
        UnitTypeResponse response = unitTypeService.getUnitTypeById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<UnitTypeResponse>> getAllUnitTypes() {
        log.info("REST request to get all unit types");
        List<UnitTypeResponse> response = unitTypeService.getAllUnitTypes();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<UnitTypeResponse> updateUnitType(Integer id, UnitTypeRequest request) {
        log.info("REST request to update unit type with id: {}", id);
        UnitTypeResponse response = unitTypeService.updateUnitType(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteUnitType(Integer id) {
        log.info("REST request to delete unit type with id: {}", id);
        unitTypeService.deleteUnitType(id);
        return ResponseEntity.noContent().build();
    }
} 