package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ProjectScopeDao;
import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;
import in.oxidane.work.done.project.entity.ProjectScope;
import in.oxidane.work.done.project.mapper.ProjectScopeMapper;
import in.oxidane.work.done.project.service.ProjectScopeService;
import in.oxidane.work.done.project.validator.ProjectScopeValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
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
    private final ProjectScopeValidator projectScopeValidator;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ProjectScopeResponse createProjectScope(ProjectScopeRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Creating new project scope");
            log.debug("Project scope request: {}", request);

            projectScopeValidator.validateForCreate(request);

            ProjectScope projectScope = projectScopeMapper.toEntity(request);
            ProjectScope savedProjectScope = projectScopeDao.create(projectScope);

            log.info("Successfully created project scope with id: {}", savedProjectScope.getProjectScopeId());
            return projectScopeMapper.toResponse(savedProjectScope);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public ProjectScopeResponse getProjectScopeById(Integer id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Fetching project scope with id: {}", id);

            ProjectScope projectScope = projectScopeDao.getById(id)
                .orElseThrow(() -> {
                    log.warn("Project scope not found with id: {}", id);
                    return new ResourceNotFoundException("Project scope not found with id: " + id);
                });

            log.debug("Retrieved project scope: {}", projectScope);
            return projectScopeMapper.toResponse(projectScope);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProjectScopeResponse> getAllProjectScopes() {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Fetching all project scopes");

            List<ProjectScope> projectScopes = projectScopeDao.getAll();
            log.debug("Retrieved {} project scopes", projectScopes.size());

            return projectScopes.stream()
                .map(projectScopeMapper::toResponse)
                .collect(Collectors.toList());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ProjectScopeResponse updateProjectScope(Integer id, ProjectScopeRequest request) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
            log.info("Updating project scope with id: {}", id);
            log.debug("Update request: {}", request);

            projectScopeValidator.validateForUpdate(request, id);

            // Check if the resource exists first
            if (!projectScopeDao.existsById(id)) {
                log.warn("Project scope not found with id: {}", id);
                throw new ResourceNotFoundException("Project scope not found with id: " + id);
            }

            // Map request to entity and set the ID
            ProjectScope projectScope = projectScopeMapper.toEntity(request);
            projectScope.setProjectScopeId(id);

            // Update and convert response
            ProjectScope updatedProjectScope = projectScopeDao.update(projectScope);

            log.info("Successfully updated project scope with id: {}", id);
            return projectScopeMapper.toResponse(updatedProjectScope);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteProjectScope(Integer id) {
        try (MDC.MDCCloseable _ = MDC.putCloseable("requestId", UUID.randomUUID().toString())) {
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
}
