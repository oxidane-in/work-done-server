package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ProjectDao;
import in.oxidane.work.done.project.dto.ProjectRequest;
import in.oxidane.work.done.project.dto.ProjectResponse;
import in.oxidane.work.done.project.entity.Project;
import in.oxidane.work.done.project.mapper.ProjectMapper;
import in.oxidane.work.done.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectDao projectDao;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Project project = projectMapper.toEntity(request);
        Project savedProject = projectDao.save(project);
        return projectMapper.toResponse(savedProject);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        return projectMapper.toResponse(project);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = projectDao.findAll();
        return projectMapper.toResponse(projects);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project existingProject = projectDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

        Project updatedProject = projectMapper.toUpdateEntityFromRequest(request, existingProject);
        Project savedProject = projectDao.save(updatedProject);
        return projectMapper.toResponse(savedProject);
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectDao.existsById(id)) {
            throw new ResourceNotFoundException("Project not found with id: " + id);
        }
        projectDao.deleteById(id);
    }
}
