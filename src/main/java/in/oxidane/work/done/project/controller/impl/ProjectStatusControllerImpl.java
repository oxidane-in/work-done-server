package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ProjectStatusController;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.service.ProjectStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the ProjectStatusController interface.
 * Handles HTTP requests related to project status operations.
 */
@RestController
@RequiredArgsConstructor
public class ProjectStatusControllerImpl implements ProjectStatusController {

    private final ProjectStatusService projectStatusService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> createProjectStatus(ProjectStatusRequest request) {
        ProjectStatusResponse response = projectStatusService.createProjectStatus(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> getProjectStatusById(Long id) {
        ProjectStatusResponse response = projectStatusService.getProjectStatusById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<ProjectStatusResponse>> getAllProjectStatuses() {
        List<ProjectStatusResponse> response = projectStatusService.getAllProjectStatuses();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> updateProjectStatus(Long id, ProjectStatusRequest request) {
        ProjectStatusResponse response = projectStatusService.updateProjectStatus(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteProjectStatus(Long id) {
        projectStatusService.deleteProjectStatus(id);
        return ResponseEntity.noContent().build();
    }
}
