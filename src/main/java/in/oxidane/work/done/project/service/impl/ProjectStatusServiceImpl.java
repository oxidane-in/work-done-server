package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ProjectStatusDao;
import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;
import in.oxidane.work.done.project.entity.ProjectStatus;
import in.oxidane.work.done.project.mapper.ProjectStatusMapper;
import in.oxidane.work.done.project.service.ProjectStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ProjectStatusService interface.
 * Provides business operations for ProjectStatus entities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectStatusServiceImpl implements ProjectStatusService {

    private final ProjectStatusDao projectStatusDao;
    private final ProjectStatusMapper projectStatusMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectStatusResponse createProjectStatus(ProjectStatusRequest request) {
        log.info("Creating new project status");
        log.debug("Project status request: {}", request);

        ProjectStatus projectStatus = projectStatusMapper.toEntity(request);
        ProjectStatus savedProjectStatus = projectStatusDao.create(projectStatus);

        log.info("Successfully created project status with id: {}", savedProjectStatus.getProjectStatusId());
        return projectStatusMapper.toResponse(savedProjectStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectStatusResponse getProjectStatusById(Long id) {
        log.info("Fetching project status with id: {}", id);

        ProjectStatus projectStatus = projectStatusDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Project status not found with id: {}", id);
                return new ResourceNotFoundException("Project status not found with id: " + id);
            });

        log.debug("Retrieved project status: {}", projectStatus);
        return projectStatusMapper.toResponse(projectStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProjectStatusResponse> getAllProjectStatuses() {
        log.info("Fetching all project statuses");

        List<ProjectStatus> projectStatuses = projectStatusDao.getAll();
        log.debug("Retrieved {} project statuses", projectStatuses.size());

        return projectStatuses.stream()
            .map(projectStatusMapper::toResponse)
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectStatusResponse updateProjectStatus(Long id, ProjectStatusRequest request) {
        log.info("Updating project status with id: {}", id);
        log.debug("Update request: {}", request);

        ProjectStatus existingProjectStatus = projectStatusDao.getById(id)
            .orElseThrow(() -> {
                log.warn("Project status not found with id: {}", id);
                return new ResourceNotFoundException("Project status not found with id: " + id);
            });

        ProjectStatus projectStatus = projectStatusMapper.toUpdateEntityFromRequest(request, existingProjectStatus);

        log.debug("Updating project status: {}", projectStatus);

        // Update and convert response
        ProjectStatus updatedProjectStatus = projectStatusDao.update(projectStatus);

        log.info("Successfully updated project status with id: {}", id);
        return projectStatusMapper.toResponse(updatedProjectStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteProjectStatus(Long id) {
        log.info("Deleting project status with id: {}", id);

        // Check if the resource exists first
        if (!projectStatusDao.existsById(id)) {
            log.warn("Cannot delete - project status not found with id: {}", id);
            throw new ResourceNotFoundException("Project status not found with id: " + id);
        }

        projectStatusDao.delete(id);
        log.info("Successfully deleted project status with id: {}", id);
    }
}
