package in.oxidane.work.done.building.repository;

import in.oxidane.work.done.building.entity.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for UnitType entity.
 * Provides JPA operations for UnitType.
 */
@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {

    /**
     * Finds a unit type by its handle.
     *
     * @param handle The handle to search for
     * @return An Optional containing the unit type if found, or empty if not found
     */
    Optional<UnitType> findByUnitTypeHandle(String handle);

    /**
     * Checks if a unit type with the specified handle exists.
     *
     * @param handle The handle to check
     * @return true if a unit type with the handle exists, false otherwise
     */
    boolean existsByUnitTypeHandle(String handle);

}
