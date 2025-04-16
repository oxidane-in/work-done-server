package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ProjectOtherCostPlannedDao;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedResponse;
import in.oxidane.work.done.project.entity.ProjectOtherCostPlanned;
import in.oxidane.work.done.project.mapper.ProjectOtherCostPlannedMapper;
import in.oxidane.work.done.project.service.ProjectOtherCostPlannedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectOtherCostPlannedServiceImpl implements ProjectOtherCostPlannedService {

    private final ProjectOtherCostPlannedDao projectOtherCostPlannedDao;
    private final ProjectOtherCostPlannedMapper projectOtherCostPlannedMapper;

    @Override
    public ProjectOtherCostPlannedResponse createOtherCostPlanned(ProjectOtherCostPlannedRequest request) {
        ProjectOtherCostPlanned otherCostPlanned = projectOtherCostPlannedMapper.toEntity(request);
        ProjectOtherCostPlanned savedOtherCostPlanned = projectOtherCostPlannedDao.save(otherCostPlanned);
        return projectOtherCostPlannedMapper.toResponse(savedOtherCostPlanned);
    }

    @Override
    public ProjectOtherCostPlannedResponse getOtherCostPlannedById(Long id) {
        ProjectOtherCostPlanned otherCostPlanned = projectOtherCostPlannedDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OtherCostPlanned not found with id: " + id));
        return projectOtherCostPlannedMapper.toResponse(otherCostPlanned);
    }

    @Override
    public List<ProjectOtherCostPlannedResponse> getAllOtherCostPlanned() {
        List<ProjectOtherCostPlanned> otherCostPlannedList = projectOtherCostPlannedDao.findAll();
        return projectOtherCostPlannedMapper.toResponse(otherCostPlannedList);
    }

    @Override
    public ProjectOtherCostPlannedResponse updateOtherCostPlanned(Long id, ProjectOtherCostPlannedRequest request) {
        ProjectOtherCostPlanned existingOtherCostPlanned = projectOtherCostPlannedDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OtherCostPlanned not found with id: " + id));

        ProjectOtherCostPlanned updatedOtherCostPlanned = projectOtherCostPlannedMapper.toUpdateEntityFromRequest(request, existingOtherCostPlanned);
        ProjectOtherCostPlanned savedOtherCostPlanned = projectOtherCostPlannedDao.save(updatedOtherCostPlanned);
        return projectOtherCostPlannedMapper.toResponse(savedOtherCostPlanned);
    }

    @Override
    public void deleteOtherCostPlanned(Long id) {
        if (!projectOtherCostPlannedDao.existsById(id)) {
            throw new ResourceNotFoundException("OtherCostPlanned not found with id: " + id);
        }
        projectOtherCostPlannedDao.deleteById(id);
    }
}
