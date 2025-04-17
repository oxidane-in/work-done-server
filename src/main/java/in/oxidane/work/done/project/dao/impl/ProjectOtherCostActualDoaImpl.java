package in.oxidane.work.done.project.dao.impl;

import in.oxidane.work.done.project.dao.ProjectOtherCostActualDao;
import in.oxidane.work.done.project.entity.ProjectOtherCostActual;
import in.oxidane.work.done.project.repository.ProjectOtherCostActualRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProjectOtherCostActualDoaImpl implements ProjectOtherCostActualDao {

    private final ProjectOtherCostActualRepository projectOtherCostActualRepository;

    @Override
    public ProjectOtherCostActual save(ProjectOtherCostActual projectOtherCostActual) {
        return projectOtherCostActualRepository.save(projectOtherCostActual);
    }

    @Override
    public Optional<ProjectOtherCostActual> findById(Long id) {
        return projectOtherCostActualRepository.findById(id);
    }

    @Override
    public List<ProjectOtherCostActual> findAll() {
        return projectOtherCostActualRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        projectOtherCostActualRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return projectOtherCostActualRepository.existsById(id);
    }
}
