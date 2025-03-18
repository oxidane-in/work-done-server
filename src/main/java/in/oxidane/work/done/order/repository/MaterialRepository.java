package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Material entity.
 * Provides JPA CRUD operations for Material data.
 */
@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {
    // Add custom query methods if needed
}
