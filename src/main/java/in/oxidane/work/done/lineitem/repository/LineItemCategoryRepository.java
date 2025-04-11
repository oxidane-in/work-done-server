package in.oxidane.work.done.lineitem.repository;

import in.oxidane.work.done.lineitem.entity.LineItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineItemCategoryRepository extends JpaRepository<LineItemCategory, Long> {
    Optional<LineItemCategory> findByLineItemCategoryHandle(String handle);
    boolean existsByLineItemCategoryName(String name);
} 