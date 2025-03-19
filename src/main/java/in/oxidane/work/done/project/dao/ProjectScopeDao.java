package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.ProjectScope;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object interface for ProjectScope entity.
 * Provides methods to interact with the database for ProjectScope operations.
 */
public interface ProjectScopeDao {

    /**
     * Retrieves a project scope by its ID.
     *
     * @param id The ID of the project scope to retrieve
     * @return An Optional containing the project scope if found, or empty if not found
     */
    Optional<ProjectScope> getById(Integer id);

    /**
     * Retrieves all project scopes.
     *
     * @return A list of all project scopes
     */
    List<ProjectScope> getAll();

    /**
     * Creates a new project scope.
     *
     * @param projectScope The project scope to create
     * @return The created project scope with generated ID
     */
    ProjectScope create(ProjectScope projectScope);

    /**
     * Updates an existing project scope.
     *
     * @param projectScope The project scope to update
     * @return The updated project scope
     */
    ProjectScope update(ProjectScope projectScope);

    /**
     * Deletes a project scope by its ID.
     *
     * @param id The ID of the project scope to delete
     */
    void delete(Integer id);

    /**
     * Checks if a project scope with the specified ID exists.
     *
     * @param id The ID to check
     * @return true if the project scope exists, false otherwise
     */
    boolean existsById(Integer id);

    /**
     * Checks if a project scope with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a project scope with the handle exists, false otherwise
     */
    boolean existsByHandle(String handle);

    /**
     * Checks if a project scope with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id The ID to exclude from the check
     * @return true if another project scope with the handle exists, false otherwise
     */
    boolean existsByHandleAndIdNot(String handle, Integer id);
}
