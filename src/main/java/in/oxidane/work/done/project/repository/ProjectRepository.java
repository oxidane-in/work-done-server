package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Add custom query methods if needed
} 