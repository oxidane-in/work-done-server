package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemCategory;

import java.util.List;
import java.util.Optional;

public interface LineItemCategoryDao {
    LineItemCategory save(LineItemCategory category);
    List<LineItemCategory> findAll();
    Optional<LineItemCategory> findById(Long id);
    Optional<LineItemCategory> findByHandle(String handle);
    void deleteById(Long id);
    boolean existsByName(String name);
} 