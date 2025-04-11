package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    Project save(Project project);
    Optional<Project> findById(Long id);
    List<Project> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
} 