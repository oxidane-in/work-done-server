package in.oxidane.work.done.project.dao.impl;

import in.oxidane.work.done.project.dao.ProjectOtherCostPlannedDao;
import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import in.oxidane.work.done.project.repository.ProjectOtherCostPlannedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectOtherCostPlannedDoaImpl implements ProjectOtherCostPlannedDao {

    private final ProjectOtherCostPlannedRepository projectOtherCostPlannedRepository;

    @Override
    public ProjectOtherCostPlanned save(ProjectOtherCostPlanned projectOtherCostPlanned) {
        return projectOtherCostPlannedRepository.save(projectOtherCostPlanned);
    }

    @Override
    public Optional<ProjectOtherCostPlanned> findById(Long id) {
        return projectOtherCostPlannedRepository.findById(id);
    }

    @Override
    public List<ProjectOtherCostPlanned> findAll() {
        return projectOtherCostPlannedRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
       projectOtherCostPlannedRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return projectOtherCostPlannedRepository.existsById(id);
    }
}
