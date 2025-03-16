package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.model.MaterialManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialManufacturerRepository extends JpaRepository<MaterialManufacturer, Integer> {
    // Add custom query methods if needed
} 