package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for UnitOfMeasurement entity.
 * Provides JPA operations for UnitOfMeasurement.
 */
@Repository
public interface UnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Long> {

    /**
     * Finds a unit of measurement by its handle.
     *
     * @param handle The handle to search for
     * @return An Optional containing the unit of measurement if found, or empty if not found
     */
    Optional<UnitOfMeasurement> findByUomHandle(String handle);

    /**
     * Checks if a unit of measurement with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a unit of measurement with the handle exists, false otherwise
     */
    boolean existsByUomHandle(String handle);
}
