package in.oxidane.work.done.order.repository;

import in.oxidane.work.done.order.entity.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
    
    Optional<LineItem> findByLineItemHandle(String handle);
    
    boolean existsByLineItemHandle(String handle);
    
    boolean existsByLineItemHandleAndLineItemIdNot(String handle, Integer id);
    
    List<LineItem> findByUnitOfMeasurement_UomId(Integer uomId);
} 