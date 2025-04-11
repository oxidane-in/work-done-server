package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemHeader;

import java.util.List;
import java.util.Optional;

public interface LineItemHeaderDao {
    LineItemHeader save(LineItemHeader lineItemHeader);
    List<LineItemHeader> findAll();
    Optional<LineItemHeader> findById(Long id);
    Optional<LineItemHeader> findByHandle(String handle);
    void deleteById(Long id);
    boolean existsByName(String name);
} 