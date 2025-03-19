package in.oxidane.work.done.material.repository;

import in.oxidane.work.done.material.entity.MaterialVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialVendorRepository extends JpaRepository<MaterialVendor, Integer> {
    // Add custom query methods if needed
}
