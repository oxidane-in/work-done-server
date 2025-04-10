package in.oxidane.work.done.lineitem.repository;

import in.oxidane.work.done.lineitem.entity.LineItemWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemWorkerRepository extends JpaRepository<LineItemWorker, Long> {
} 