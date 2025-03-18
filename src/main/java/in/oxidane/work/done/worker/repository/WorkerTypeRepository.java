package in.oxidane.work.done.worker.repository;

import in.oxidane.work.done.worker.entity.WorkerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerTypeRepository extends JpaRepository<WorkerType, Integer> {
    // Add custom query methods if needed
}
