package in.oxidane.work.done.project.service;


import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostPlannedResponse;

import java.util.List;

public interface ProjectOtherCostPlannedService {
    ProjectOtherCostPlannedResponse createOtherCostPlanned(ProjectOtherCostPlannedRequest request);
    ProjectOtherCostPlannedResponse getOtherCostPlannedById(Long id);
    List<ProjectOtherCostPlannedResponse> getAllOtherCostPlanned();
    ProjectOtherCostPlannedResponse updateOtherCostPlanned(Long id, ProjectOtherCostPlannedRequest request);
    void deleteOtherCostPlanned(Long id);
}
