package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ProjectOtherCostPlannedController;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedResponse;
import in.oxidane.work.done.project.service.ProjectOtherCostPlannedService;
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

@RestController
@RequiredArgsConstructor
public class ProjectOtherCostPlannedControllerImpl implements ProjectOtherCostPlannedController {

    private final ProjectOtherCostPlannedService projectOtherCostPlannedService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createProjectOtherCostPlanned;
    private String updateProjectOtherCostPlanned;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_PROJECT_OTHER_COST_ACTUAL_SCHEMA).getInputStream()) {
            createProjectOtherCostPlanned = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_PROJECT_OTHER_COST_PLANNED_SCHEMA).getInputStream()) {
            updateProjectOtherCostPlanned = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<ProjectOtherCostPlannedResponse> createProjectOtherCostPlanned(ProjectOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createProjectOtherCostPlanned, objectMapper.writeValueAsString(request));
        ProjectOtherCostPlannedResponse response = projectOtherCostPlannedService.createOtherCostPlanned(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProjectOtherCostPlannedResponse> getOtherCostPlannedById(Long id) {
        ProjectOtherCostPlannedResponse response = projectOtherCostPlannedService.getOtherCostPlannedById(id);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ProjectOtherCostPlannedResponse>> getAllOtherCostPlanned() {
        List<ProjectOtherCostPlannedResponse> responses = projectOtherCostPlannedService.getAllOtherCostPlanned();
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<ProjectOtherCostPlannedResponse> updateOtherCostPlanned(Long id, ProjectOtherCostPlannedRequest request)
        throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateProjectOtherCostPlanned, objectMapper.writeValueAsString(request));
        ProjectOtherCostPlannedResponse response = projectOtherCostPlannedService.updateOtherCostPlanned(id, request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteOtherCostPlanned(Long id) {
        projectOtherCostPlannedService.deleteOtherCostPlanned(id);
        return ResponseEntity.noContent().build();
    }
}
