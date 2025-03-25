package in.oxidane.work.done.project.service;

import in.oxidane.work.done.project.dto.ProjectStatusRequest;
import in.oxidane.work.done.project.dto.ProjectStatusResponse;

import java.util.List;

/**
 * Service interface for ProjectStatus operations.
 */
public interface ProjectStatusService {

    /**
     * Creates a new project status.
     *
     * @param request The request containing project status details
     * @return The created project status
     */
    ProjectStatusResponse createProjectStatus(ProjectStatusRequest request);

    /**
     * Retrieves a project status by its ID.
     *
     * @param id The ID of the project status to retrieve
     * @return The project status
     */
    ProjectStatusResponse getProjectStatusById(Long id);

    /**
     * Retrieves all project statuses.
     *
     * @return A list of all project statuses
     */
    List<ProjectStatusResponse> getAllProjectStatuses();

    /**
     * Updates an existing project status.
     *
     * @param id The ID of the project status to update
     * @param request The request containing updated project status details
     * @return The updated project status
     */
    ProjectStatusResponse updateProjectStatus(Long id, ProjectStatusRequest request);

    /**
     * Deletes a project status by its ID.
     *
     * @param id The ID of the project status to delete
     */
    void deleteProjectStatus(Long id);
}
