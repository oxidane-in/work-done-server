package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.ProjectOtherCostActual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectOtherCostActualRepository extends JpaRepository<ProjectOtherCostActual, Long> {
}
