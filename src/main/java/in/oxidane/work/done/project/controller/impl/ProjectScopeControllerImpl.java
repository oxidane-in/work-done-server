package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ProjectScopeController;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.service.ProjectScopeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the ProjectScopeController interface.
 * Handles HTTP requests related to project scope operations.
 */
@RestController
@RequiredArgsConstructor
public class ProjectScopeControllerImpl implements ProjectScopeController {

    private final ProjectScopeService projectScopeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> createProjectScope(ProjectScopeRequest request) {
        ProjectScopeResponse response = projectScopeService.createProjectScope(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> getProjectScopeById(Long id) {
        ProjectScopeResponse response = projectScopeService.getProjectScopeById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<ProjectScopeResponse>> getAllProjectScopes() {
        List<ProjectScopeResponse> response = projectScopeService.getAllProjectScopes();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> updateProjectScope(Long id, ProjectScopeRequest request) {
        ProjectScopeResponse response = projectScopeService.updateProjectScope(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteProjectScope(Long id) {
        projectScopeService.deleteProjectScope(id);
        return ResponseEntity.noContent().build();
    }
}
