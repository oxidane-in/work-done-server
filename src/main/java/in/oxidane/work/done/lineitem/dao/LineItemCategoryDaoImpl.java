package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemCategory;
import in.oxidane.work.done.lineitem.repository.LineItemCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LineItemCategoryDaoImpl implements LineItemCategoryDao {
    
    private final LineItemCategoryRepository repository;
    
    @Override
    public LineItemCategory save(LineItemCategory category) {
        return repository.save(category);
    }
    
    @Override
    public List<LineItemCategory> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<LineItemCategory> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Optional<LineItemCategory> findByHandle(String handle) {
        return repository.findByLineItemCategoryHandle(handle);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public boolean existsByName(String name) {
        return repository.existsByLineItemCategoryName(name);
    }
} 