package in.oxidane.work.done.worker.dao;

import in.oxidane.work.done.worker.entity.Worker;

import java.util.List;
import java.util.Optional;

public interface WorkerDao {
    Worker save(Worker worker);

    List<Worker> findAll();

    Optional<Worker> findById(Long id);

    void delete(Long id);

    boolean existsById(Long id);
}
