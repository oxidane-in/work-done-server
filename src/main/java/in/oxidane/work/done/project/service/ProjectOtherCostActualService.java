package in.oxidane.work.done.project.service;

import in.oxidane.work.done.project.dto.ProjectOtherCostActualRequest;
import in.oxidane.work.done.project.dto.ProjectOtherCostActualResponse;
import java.util.List;

public interface ProjectOtherCostActualService {
    ProjectOtherCostActualResponse createOtherCostActual(ProjectOtherCostActualRequest request);
    ProjectOtherCostActualResponse getOtherCostActualById(Long id);
    List<ProjectOtherCostActualResponse> getAllOtherCostActual();
    ProjectOtherCostActualResponse updateOtherCostActual(Long id, ProjectOtherCostActualRequest request);
    void deleteOtherCostActual(Long id);
}
