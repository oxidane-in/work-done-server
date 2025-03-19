package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ProjectScopeController;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.service.ProjectScopeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the ProjectScopeController interface.
 * Handles HTTP requests related to project scope operations.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProjectScopeControllerImpl implements ProjectScopeController {

    private final ProjectScopeService projectScopeService;

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> createProjectScope(ProjectScopeRequest request) {
        log.info("REST request to create project scope");
        ProjectScopeResponse response = projectScopeService.createProjectScope(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> getProjectScopeById(Integer id) {
        log.info("REST request to get project scope with id: {}", id);
        ProjectScopeResponse response = projectScopeService.getProjectScopeById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<List<ProjectScopeResponse>> getAllProjectScopes() {
        log.info("REST request to get all project scopes");
        List<ProjectScopeResponse> response = projectScopeService.getAllProjectScopes();
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> updateProjectScope(Integer id, ProjectScopeRequest request) {
        log.info("REST request to update project scope with id: {}", id);
        ProjectScopeResponse response = projectScopeService.updateProjectScope(id, request);
        return ResponseEntity.ok(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<Void> deleteProjectScope(Integer id) {
        log.info("REST request to delete project scope with id: {}", id);
        projectScopeService.deleteProjectScope(id);
        return ResponseEntity.noContent().build();
    }
}
