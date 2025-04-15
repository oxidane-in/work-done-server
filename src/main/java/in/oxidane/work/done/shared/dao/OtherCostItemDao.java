package in.oxidane.work.done.shared.dao;

import in.oxidane.work.done.shared.entity.OtherCostItem;

import java.util.List;
import java.util.Optional;

public interface OtherCostItemDao {

    // CRUD Operations
    OtherCostItem save(OtherCostItem otherCostItem);

    List<OtherCostItem> findAll();

    Optional<OtherCostItem> findById(Long id);

    void delete(Long id);

    boolean existById(Long id);
}
