package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ProjectStatusController;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.service.ProjectStatusService;
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
 * Implementation of the ProjectStatusController interface.
 * Handles HTTP requests related to project status operations.
 */
@RestController
@RequiredArgsConstructor
public class ProjectStatusControllerImpl implements ProjectStatusController {

    private final ProjectStatusService projectStatusService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createProjectStatusRequestSchema;
    private String updateProjectStatusRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_PROJECT_STATUS_REQUEST_SCHEMA).getInputStream()) {
            createProjectStatusRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_PROJECT_STATUS_REQUEST_SCHEMA).getInputStream()) {
            updateProjectStatusRequestSchema = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity<ProjectStatusResponse> createProjectStatus(ProjectStatusRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createProjectStatusRequestSchema, objectMapper.writeValueAsString(request));
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
    public ResponseEntity<Void> updateProjectStatus(Long id, ProjectStatusRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateProjectStatusRequestSchema, objectMapper.writeValueAsString(request));
        projectStatusService.updateProjectStatus(id, request);
        return ResponseEntity.ok().build();
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
