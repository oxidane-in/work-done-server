package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ProjectStatusController;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.service.ProjectStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the ProjectStatusController interface.
 * Handles HTTP requests related to project status operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProjectStatusControllerImpl implements ProjectStatusController {

    private final ProjectStatusService projectStatusService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> createProjectStatus(ProjectStatusRequest request) {
        log.info("REST request to create project status");
        ProjectStatusResponse response = projectStatusService.createProjectStatus(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> getProjectStatusById(Integer id) {
        log.info("REST request to get project status with id: {}", id);
        ProjectStatusResponse response = projectStatusService.getProjectStatusById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<ProjectStatusResponse>> getAllProjectStatuses() {
        log.info("REST request to get all project statuses");
        List<ProjectStatusResponse> response = projectStatusService.getAllProjectStatuses();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> updateProjectStatus(Integer id, ProjectStatusRequest request) {
        log.info("REST request to update project status with id: {}", id);
        ProjectStatusResponse response = projectStatusService.updateProjectStatus(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteProjectStatus(Integer id) {
        log.info("REST request to delete project status with id: {}", id);
        projectStatusService.deleteProjectStatus(id);
        return ResponseEntity.noContent().build();
    }
}
