package in.oxidane.work.done.material.repository;

import in.oxidane.work.done.material.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Material entity.
 * Provides JPA CRUD operations for Material data.
 */
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    // Add custom query methods if needed
}
