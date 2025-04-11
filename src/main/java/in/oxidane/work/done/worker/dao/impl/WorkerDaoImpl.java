package in.oxidane.work.done.worker.dao.impl;

import in.oxidane.work.done.worker.dao.WorkerDao;
import in.oxidane.work.done.worker.entity.Worker;
import in.oxidane.work.done.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class WorkerDaoImpl implements WorkerDao {

    private final WorkerRepository workerRepository;

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Optional<Worker> findById(Long id) {
        return workerRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        workerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return workerRepository.existsById(id);
    }
}
