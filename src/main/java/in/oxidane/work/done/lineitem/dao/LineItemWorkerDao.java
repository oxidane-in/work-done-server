package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemWorker;

import java.util.List;
import java.util.Optional;

public interface LineItemWorkerDao {
    LineItemWorker save(LineItemWorker lineItemWorker);
    Optional<LineItemWorker> findById(Long id);
    List<LineItemWorker> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
} 