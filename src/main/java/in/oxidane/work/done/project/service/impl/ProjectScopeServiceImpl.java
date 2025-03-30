package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ProjectScopeDao;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.entity.ProjectScope;
import in.oxidane.work.done.project.mapper.ProjectScopeMapper;
import in.oxidane.work.done.project.service.ProjectScopeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ProjectScopeService interface.
 * Provides business operations for ProjectScope entities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectScopeServiceImpl implements ProjectScopeService {

    private final ProjectScopeDao projectScopeDao;
    private final ProjectScopeMapper projectScopeMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectScopeResponse createProjectScope(ProjectScopeRequest request) {
        log.info("Creating new project scope");
        log.debug("Project scope request: {}", request);

        ProjectScope projectScope = projectScopeMapper.toEntity(request);
        ProjectScope savedProjectScope = projectScopeDao.create(projectScope);

        log.info("Successfully created project scope with id: {}", savedProjectScope.getProjectScopeId());
        return projectScopeMapper.toResponse(savedProjectScope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectScopeResponse getProjectScopeById(Long id) {
        log.info("Fetching project scope with id: {}", id);

        ProjectScope projectScope = projectScopeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Project scope not found with id: {}", id);
                return new ResourceNotFoundException("Project scope not found with id: " + id);
            });

        log.debug("Retrieved project scope: {}", projectScope);
        return projectScopeMapper.toResponse(projectScope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProjectScopeResponse> getAllProjectScopes() {
        log.info("Fetching all project scopes");

        List<ProjectScope> projectScopes = projectScopeDao.getAll();
        log.debug("Retrieved {} project scopes", projectScopes.size());

        return projectScopes.stream()
            .map(projectScopeMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectScopeResponse updateProjectScope(Long id, ProjectScopeRequest request) {
        log.info("Updating project scope with id: {}", id);

        // Map request to entity and set the ID
        ProjectScope existingProjectScope = projectScopeDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Project scope not found with id: {}", id);
                return new ResourceNotFoundException("Project scope not found with id: " + id);
            });

        ProjectScope projectScope = projectScopeMapper.toUpdateEntityFromRequest(request, existingProjectScope);

        log.debug("Updating project scope: {}", projectScope);

        // Update and convert response
        ProjectScope updatedProjectScope = projectScopeDao.update(projectScope);

        log.info("Successfully updated project scope with id: {}", id);
        return projectScopeMapper.toResponse(updatedProjectScope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteProjectScope(Long id) {
        log.info("Deleting project scope with id: {}", id);

        // Check if the resource exists first
        if (!projectScopeDao.existsById(id)) {
            log.warn("Cannot delete - project scope not found with id: {}", id);
            throw new ResourceNotFoundException("Project scope not found with id: " + id);
        }

        projectScopeDao.delete(id);
        log.info("Successfully deleted project scope with id: {}", id);
    }
}
