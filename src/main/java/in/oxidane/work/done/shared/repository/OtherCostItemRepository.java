package in.oxidane.work.done.shared.repository;

import in.oxidane.work.done.shared.entity.OtherCostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherCostItemRepository extends JpaRepository<OtherCostItem, Long> {
}
