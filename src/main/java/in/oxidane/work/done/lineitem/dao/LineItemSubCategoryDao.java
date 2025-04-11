package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemSubCategory;

import java.util.List;
import java.util.Optional;

public interface LineItemSubCategoryDao {
    LineItemSubCategory save(LineItemSubCategory entity);
    List<LineItemSubCategory> findAll();
    Optional<LineItemSubCategory> findById(Long id);
    Optional<LineItemSubCategory> findByHandle(String handle);
    void deleteById(Long id);
    boolean existsByName(String name);
} 