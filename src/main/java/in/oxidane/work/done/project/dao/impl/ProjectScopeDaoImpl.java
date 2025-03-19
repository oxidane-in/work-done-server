package in.oxidane.work.done.project.dao.impl;

import in.oxidane.work.done.project.dao.ProjectScopeDao;
import in.oxidane.work.done.project.entity.ProjectScope;
import in.oxidane.work.done.project.repository.ProjectScopeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ProjectScopeDao interface.
 * Provides data access operations for ProjectScope entities.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectScopeDaoImpl implements ProjectScopeDao {

    private final ProjectScopeRepository projectScopeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ProjectScope> getById(Integer id) {
        log.debug("Fetching project scope with id: {}", id);
        return projectScopeRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProjectScope> getAll() {
        log.debug("Fetching all project scopes");
        return projectScopeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectScope create(ProjectScope projectScope) {
        log.debug("Creating project scope: {}", projectScope);
        return projectScopeRepository.save(projectScope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectScope update(ProjectScope projectScope) {
        log.debug("Updating project scope with id: {}", projectScope.getProjectScopeId());
        return projectScopeRepository.save(projectScope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        log.debug("Deleting project scope with id: {}", id);
        projectScopeRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Integer id) {
        log.debug("Checking if project scope exists with id: {}", id);
        return projectScopeRepository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandle(String handle) {
        log.debug("Checking if project scope exists with handle: {}", handle);
        return projectScopeRepository.existsByProjectScopeHandle(handle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsByHandleAndIdNot(String handle, Integer id) {
        log.debug("Checking if project scope exists with handle: {} excluding id: {}", handle, id);
        return projectScopeRepository.existsByProjectScopeHandleAndProjectScopeIdNot(handle, id);
    }
}
