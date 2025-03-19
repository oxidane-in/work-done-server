package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.ProjectScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for ProjectScope entity.
 * Provides JPA operations for ProjectScope.
 */
@Repository
public interface ProjectScopeRepository extends JpaRepository<ProjectScope, Integer> {

    /**
     * Finds a project scope by its handle.
     *
     * @param handle The handle to search for
     * @return An Optional containing the project scope if found, or empty if not found
     */
    Optional<ProjectScope> findByProjectScopeHandle(String handle);

    /**
     * Checks if a project scope with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a project scope with the handle exists, false otherwise
     */
    boolean existsByProjectScopeHandle(String handle);

    /**
     * Checks if a project scope with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id The ID to exclude from the check
     * @return true if another project scope with the handle exists, false otherwise
     */
    boolean existsByProjectScopeHandleAndProjectScopeIdNot(String handle, Integer id);
}
