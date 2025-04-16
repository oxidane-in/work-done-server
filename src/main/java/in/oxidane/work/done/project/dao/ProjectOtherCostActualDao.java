package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.ProjectOtherCostActual;

import java.util.List;
import java.util.Optional;

public interface ProjectOtherCostActualDao {
    ProjectOtherCostActual save(ProjectOtherCostActual projectOtherCostActual);

    Optional<ProjectOtherCostActual> findById(Long id);

    List<ProjectOtherCostActual> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
