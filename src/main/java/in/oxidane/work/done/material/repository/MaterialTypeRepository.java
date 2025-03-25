package in.oxidane.work.done.material.repository;

import in.oxidane.work.done.material.entity.MaterialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {
    // Add custom query methods if needed
}
