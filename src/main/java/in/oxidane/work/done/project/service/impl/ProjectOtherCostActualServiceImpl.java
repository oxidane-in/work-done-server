package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.impl.ProjectOtherCostActualDoaImpl;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostActual;
import in.oxidane.work.done.project.mapper.ProjectOtherCostActualMapper;
import in.oxidane.work.done.project.service.ProjectOtherCostActualService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectOtherCostActualServiceImpl implements ProjectOtherCostActualService {

    private final ProjectOtherCostActualDoaImpl projectOtherCostActualDoa;
    private final ProjectOtherCostActualMapper projectOtherCostActualMapper;

    @Override
    public ProjectOtherCostActualResponse createOtherCostActual(ProjectOtherCostActualRequest request) {
        ProjectOtherCostActual otherCostActual = projectOtherCostActualMapper.toEntity(request);
        ProjectOtherCostActual savedOtherCostActual = projectOtherCostActualDoa.save(otherCostActual);
        return projectOtherCostActualMapper.toResponse(savedOtherCostActual);
    }

    @Override
    public ProjectOtherCostActualResponse getOtherCostActualById(Long id) {
        ProjectOtherCostActual otherCostActual = projectOtherCostActualDoa.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OtherCostActual not found with id: " + id));
        return projectOtherCostActualMapper.toResponse(otherCostActual);
    }

    @Override
    public List<ProjectOtherCostActualResponse> getAllOtherCostActual() {
        List<ProjectOtherCostActual> otherCostActuals = projectOtherCostActualDoa.findAll();
        return projectOtherCostActualMapper.toResponse(otherCostActuals);
    }

    @Override
    public ProjectOtherCostActualResponse updateOtherCostActual(Long id, ProjectOtherCostActualRequest request) {
        ProjectOtherCostActual existingOtherCostActual = projectOtherCostActualDoa.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OtherCostActual not found with id: " + id));

        ProjectOtherCostActual updatedOtherCostActual = projectOtherCostActualMapper.toUpdateEntityFromRequest(request, existingOtherCostActual);
        ProjectOtherCostActual savedOtherCostActual = projectOtherCostActualDoa.save(updatedOtherCostActual);
        return projectOtherCostActualMapper.toResponse(savedOtherCostActual);
    }

    @Override
    public void deleteOtherCostActual(Long id) {
        if (!projectOtherCostActualDoa.existsById(id)) {
            throw new ResourceNotFoundException("OtherCostActual not found with id: " + id);
        }
        projectOtherCostActualDoa.deleteById(id);
    }
}
