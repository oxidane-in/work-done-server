package in.oxidane.work.done.lineitem.repository;

import in.oxidane.work.done.lineitem.entity.LineItemSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineItemSubCategoryRepository extends JpaRepository<LineItemSubCategory, Long> {
    Optional<LineItemSubCategory> findByLineItemSubCategoryHandle(String handle);
    boolean existsByLineItemSubCategoryName(String name);
} 