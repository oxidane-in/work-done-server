package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.model.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Integer> {
    // Add custom query methods if needed
}
