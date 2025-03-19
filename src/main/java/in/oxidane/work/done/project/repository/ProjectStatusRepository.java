package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for ProjectStatus entity.
 * Provides JPA operations for ProjectStatus.
 */
@Repository
public interface ProjectStatusRepository extends JpaRepository<ProjectStatus, Integer> {

    /**
     * Finds a project status by its handle.
     *
     * @param handle The handle to search for
     * @return An Optional containing the project status if found, or empty if not found
     */
    Optional<ProjectStatus> findByProjectStatusHandle(String handle);

    /**
     * Checks if a project status with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a project status with the handle exists, false otherwise
     */
    boolean existsByProjectStatusHandle(String handle);

    /**
     * Checks if a project status with the specified handle exists, excluding the one with the specified ID.
     *
     * @param handle The handle to check
     * @param id The ID to exclude from the check
     * @return true if another project status with the handle exists, false otherwise
     */
    boolean existsByProjectStatusHandleAndProjectStatusIdNot(String handle, Integer id);
}
