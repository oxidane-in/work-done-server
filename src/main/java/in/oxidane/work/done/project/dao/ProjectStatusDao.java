package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.ProjectStatus;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for ProjectStatus entity.
 * Provides methods to interact with the database for ProjectStatus operations.
 */
public interface ProjectStatusDao {

    /**
     * Retrieves a project status by its ID.
     *
     * @param id The ID of the project status to retrieve
     * @return An Optional containing the project status if found, or empty if not found
     */
    Optional<ProjectStatus> getById(Integer id);

    /**
     * Retrieves all project statuses.
     *
     * @return A list of all project statuses
     */
    List<ProjectStatus> getAll();

    /**
     * Creates a new project status.
     *
     * @param projectStatus The project status to create
     * @return The created project status with generated ID
     */
    ProjectStatus create(ProjectStatus projectStatus);

    /**
     * Updates an existing project status.
     *
     * @param projectStatus The project status to update
     * @return The updated project status
     */
    ProjectStatus update(ProjectStatus projectStatus);

    /**
     * Deletes a project status by its ID.
     *
     * @param id The ID of the project status to delete
     */
    void delete(Integer id);

    /**
     * Checks if a project status with the specified ID exists.
     *
     * @param id The ID to check
     * @return true if the project status exists, false otherwise
     */
    boolean existsById(Integer id);

    /**
     * Checks if a project status with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a project status with the handle exists, false otherwise
     */
    boolean existsByHandle(String handle);

    /**
     * Checks if a project status with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id The ID to exclude from the check
     * @return true if another project status with the handle exists, false otherwise
     */
    boolean existsByHandleAndIdNot(String handle, Integer id);
}
