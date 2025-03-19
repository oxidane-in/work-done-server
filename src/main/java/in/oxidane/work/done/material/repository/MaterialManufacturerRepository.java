package in.oxidane.work.done.material.repository;

import in.oxidane.work.done.material.entity.MaterialManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialManufacturerRepository extends JpaRepository<MaterialManufacturer, Integer> {
    // Add custom query methods if needed
}
