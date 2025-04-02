package in.oxidane.work.done.project.service;

import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;

import java.util.List;

public interface ProjectService {
    ProjectResponse createProject(ProjectRequest request);
    ProjectResponse getProjectById(Long id);
    List<ProjectResponse> getAllProjects();
    ProjectResponse updateProject(Long id, ProjectRequest request);
    void deleteProject(Long id);
} 