package in.oxidane.work.done.project.dao.impl;

import in.oxidane.work.done.project.dao.ProjectStatusDao;
import in.oxidane.work.done.project.entity.ProjectStatus;
import in.oxidane.work.done.project.repository.ProjectStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ProjectStatusDao interface.
 * Provides data access operations for ProjectStatus entities.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectStatusDaoImpl implements ProjectStatusDao {

    private final ProjectStatusRepository projectStatusRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ProjectStatus> getById(Integer id) {
        log.debug("Fetching project status with id: {}", id);
        return projectStatusRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProjectStatus> getAll() {
        log.debug("Fetching all project statuses");
        return projectStatusRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectStatus create(ProjectStatus projectStatus) {
        log.debug("Creating project status: {}", projectStatus);
        return projectStatusRepository.save(projectStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectStatus update(ProjectStatus projectStatus) {
        log.debug("Updating project status with id: {}", projectStatus.getProjectStatusId());
        return projectStatusRepository.save(projectStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        log.debug("Deleting project status with id: {}", id);
        projectStatusRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Integer id) {
        log.debug("Checking if project status exists with id: {}", id);
        return projectStatusRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandle(String handle) {
        log.debug("Checking if project status exists with handle: {}", handle);
        return projectStatusRepository.existsByProjectStatusHandle(handle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandleAndIdNot(String handle, Integer id) {
        log.debug("Checking if project status exists with handle: {} excluding id: {}", handle, id);
        return projectStatusRepository.existsByProjectStatusHandleAndProjectStatusIdNot(handle, id);
    }
}
