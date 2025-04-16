package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectOtherCostPlannedRepository extends JpaRepository<ProjectOtherCostPlanned, Long> {
}
