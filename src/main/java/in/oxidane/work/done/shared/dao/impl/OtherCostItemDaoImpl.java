package in.oxidane.work.done.shared.dao.impl;

import in.oxidane.work.done.shared.dao.OtherCostItemDao;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import in.oxidane.work.done.shared.repository.OtherCostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OtherCostItemDaoImpl implements OtherCostItemDao {

    private final OtherCostItemRepository otherCostItemRepository;

    @Override
    public OtherCostItem save(OtherCostItem otherCostItem) {
        return otherCostItemRepository.save(otherCostItem);
    }

    @Override
    public List<OtherCostItem> findAll() {
        return otherCostItemRepository.findAll();
    }

    @Override
    public Optional<OtherCostItem> findById(Long id) {
        return otherCostItemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        otherCostItemRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return otherCostItemRepository.existsById(id);
    }
}
