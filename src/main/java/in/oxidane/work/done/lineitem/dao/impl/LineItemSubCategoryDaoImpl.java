package in.oxidane.work.done.lineitem.dao.impl;

import in.oxidane.work.done.lineitem.dao.LineItemSubCategoryDao;
import in.oxidane.work.done.lineitem.entity.LineItemSubCategory;
import in.oxidane.work.done.lineitem.repository.LineItemSubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LineItemSubCategoryDaoImpl implements LineItemSubCategoryDao {

    private final LineItemSubCategoryRepository repository;

    @Override
    public LineItemSubCategory save(LineItemSubCategory entity) {
        return repository.save(entity);
    }

    @Override
    public List<LineItemSubCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LineItemSubCategory> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<LineItemSubCategory> findByHandle(String handle) {
        return repository.findByLineItemSubCategoryHandle(handle);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByLineItemSubCategoryName(name);
    }
} 