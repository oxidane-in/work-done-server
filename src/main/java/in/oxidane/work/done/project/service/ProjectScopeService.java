package in.oxidane.work.done.project.service;

import in.oxidane.work.done.project.dto.ProjectScopeRequest;
import in.oxidane.work.done.project.dto.ProjectScopeResponse;

import java.util.List;

/**
 * Service interface for ProjectScope operations.
 */
public interface ProjectScopeService {

    /**
     * Creates a new project scope.
     *
     * @param request The request containing project scope details
     * @return The created project scope
     */
    ProjectScopeResponse createProjectScope(ProjectScopeRequest request);

    /**
     * Retrieves a project scope by its ID.
     *
     * @param id The ID of the project scope to retrieve
     * @return The project scope
     */
    ProjectScopeResponse getProjectScopeById(Long id);

    /**
     * Retrieves all project scopes.
     *
     * @return A list of all project scopes
     */
    List<ProjectScopeResponse> getAllProjectScopes();

    /**
     * Updates an existing project scope.
     *
     * @param id The ID of the project scope to update
     * @param request The request containing updated project scope details
     * @return The updated project scope
     */
    ProjectScopeResponse updateProjectScope(Long id, ProjectScopeRequest request);

    /**
     * Deletes a project scope by its ID.
     *
     * @param id The ID of the project scope to delete
     */
    void deleteProjectScope(Long id);
}
