package in.oxidane.work.done.lineitem.dao.impl;

import in.oxidane.work.done.lineitem.dao.LineItemHeaderDao;
import in.oxidane.work.done.lineitem.entity.LineItemHeader;
import in.oxidane.work.done.lineitem.repository.LineItemHeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LineItemHeaderDaoImpl implements LineItemHeaderDao {
    
    private final LineItemHeaderRepository repository;
    
    @Override
    public LineItemHeader save(LineItemHeader lineItemHeader) {
        return repository.save(lineItemHeader);
    }
    
    @Override
    public List<LineItemHeader> findAll() {
        return repository.findAll();
    }
    
    @Override
    public Optional<LineItemHeader> findById(Long id) {
        return repository.findById(id);
    }
    
    @Override
    public Optional<LineItemHeader> findByHandle(String handle) {
        return repository.findByLineItemHeaderHandle(handle);
    }
    
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public boolean existsByName(String name) {
        return repository.existsByLineItemHeaderName(name);
    }
} 