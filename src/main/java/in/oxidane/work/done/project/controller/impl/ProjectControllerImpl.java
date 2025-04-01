package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ProjectController;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
import in.oxidane.work.done.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectController {

    private final ProjectService projectService;

    @Override
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request) {
        ProjectResponse createdProject = projectService.createProject(request);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id) {
        ProjectResponse project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @Override
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,
                                                         @RequestBody ProjectRequest request) {
        ProjectResponse updatedProject = projectService.updateProject(id, request);
        return ResponseEntity.ok(updatedProject);
    }

    @Override
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
