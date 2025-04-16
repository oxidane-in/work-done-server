package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;

import java.util.List;
import java.util.Optional;

public interface ProjectOtherCostPlannedDao {
    ProjectOtherCostPlanned save(ProjectOtherCostPlanned projectOtherCostPlanned);

    Optional<ProjectOtherCostPlanned> findById(Long id);

    List<ProjectOtherCostPlanned> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
