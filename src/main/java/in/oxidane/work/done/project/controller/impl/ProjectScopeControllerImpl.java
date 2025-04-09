package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ProjectScopeController;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.service.ProjectScopeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Implementation of the ProjectScopeController interface.
 * Handles HTTP requests related to project scope operations.
 */
@RestController
@RequiredArgsConstructor
public class ProjectScopeControllerImpl implements ProjectScopeController {

    private final ProjectScopeService projectScopeService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createProjectScopeRequestSchema;
    private String updateProjectScopeRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_PROJECT_SCOPE_REQUEST_SCHEMA).getInputStream()) {
            createProjectScopeRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_PROJECT_SCOPE_REQUEST_SCHEMA).getInputStream()) {
            updateProjectScopeRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectScopeResponse> createProjectScope(ProjectScopeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createProjectScopeRequestSchema, objectMapper.writeValueAsString(request));
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
    public ResponseEntity<Void> updateProjectScope(Long id, ProjectScopeRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateProjectScopeRequestSchema, objectMapper.writeValueAsString(request));
        projectScopeService.updateProjectScope(id, request);
        return ResponseEntity.ok().build();
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
