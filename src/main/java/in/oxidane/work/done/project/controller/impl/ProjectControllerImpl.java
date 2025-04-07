package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ProjectController;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
import in.oxidane.work.done.project.service.ProjectService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createProjectRequestSchema;
    private String updateProjectRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_PROJECT_REQUEST_SCHEMA).getInputStream()) {
            createProjectRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_PROJECT_REQUEST_SCHEMA).getInputStream()) {
            updateProjectRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<ProjectResponse> createProject(ProjectRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createProjectRequestSchema,objectMapper.writeValueAsString(request));
        ProjectResponse createdProject = projectService.createProject(request);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProjectResponse> getProjectById(Long id) {
        ProjectResponse project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @Override
    public ResponseEntity<ProjectResponse> updateProject(Long id,
                                                         ProjectRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateProjectRequestSchema,objectMapper.writeValueAsString(request));
        ProjectResponse updatedProject = projectService.updateProject(id, request);
        return ResponseEntity.ok(updatedProject);
    }

    @Override
    public ResponseEntity<Void> deleteProject(Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
