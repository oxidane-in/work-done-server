package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ProjectOtherCostActualController;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualResponse;
import in.oxidane.work.done.project.service.impl.ProjectOtherCostActualServiceImpl;
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
public class ProjectOtherCostActualControllerImpl implements ProjectOtherCostActualController {

    private final ProjectOtherCostActualServiceImpl projectOtherCostActualService;

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createProjectOtherCostActual;
    private String updateProjectOtherCostActual;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_PROJECT_OTHER_COST_ACTUAL_SCHEMA).getInputStream()) {
            createProjectOtherCostActual = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_PROJECT_OTHER_COST_PLANNED_SCHEMA).getInputStream()) {
            updateProjectOtherCostActual = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<ProjectOtherCostActualResponse> createProjectOtherCostActual(ProjectOtherCostActualRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createProjectOtherCostActual, objectMapper.writeValueAsString(request));
        ProjectOtherCostActualResponse createdOtherCostActual = projectOtherCostActualService.createOtherCostActual(request);
        return new ResponseEntity<>(createdOtherCostActual, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProjectOtherCostActualResponse> getOtherCostActualById(Long id) {
        ProjectOtherCostActualResponse otherCostActual = projectOtherCostActualService.getOtherCostActualById(id);
        return ResponseEntity.ok(otherCostActual);
    }

    @Override
    public ResponseEntity<List<ProjectOtherCostActualResponse>> getAllOtherCostActual() {
        List<ProjectOtherCostActualResponse> allOtherCostActual = projectOtherCostActualService.getAllOtherCostActual();
        return  ResponseEntity.ok(allOtherCostActual);
    }

    @Override
    public ResponseEntity<ProjectOtherCostActualResponse> updateOtherCostActual(Long id, ProjectOtherCostActualRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateProjectOtherCostActual, objectMapper.writeValueAsString(request));
        ProjectOtherCostActualResponse updatedOtherCostActual = projectOtherCostActualService.updateOtherCostActual(id, request);
        return  ResponseEntity.ok(updatedOtherCostActual);
    }

    @Override
    public ResponseEntity<Void> deleteOtherCostActual(Long id) {
        projectOtherCostActualService.deleteOtherCostActual(id);
        return ResponseEntity.noContent().build();
    }
}
