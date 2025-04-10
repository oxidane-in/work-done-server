package in.oxidane.work.done.lineitem.dao.impl;

import in.oxidane.work.done.lineitem.dao.LineItemWorkerDao;
import in.oxidane.work.done.lineitem.entity.LineItemWorker;
import in.oxidane.work.done.lineitem.repository.LineItemWorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LineItemWorkerDaoImpl implements LineItemWorkerDao {

    private final LineItemWorkerRepository repository;

    @Override
    public LineItemWorker save(LineItemWorker lineItemWorker) {
        return repository.save(lineItemWorker);
    }

    @Override
    public Optional<LineItemWorker> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<LineItemWorker> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
} 