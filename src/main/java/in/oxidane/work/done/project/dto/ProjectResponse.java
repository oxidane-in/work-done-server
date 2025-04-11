package in.oxidane.work.done.project.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProjectResponse extends AuditableResponse {
    private Long projectId;
    private String projectName;
    private String projectLocation;
    private String projectCity;
    private String projectState;
    private ClientResponse client;
    private ProjectStatusResponse projectStatus;
    private LocalDate projectStartDate;
    private LocalDate projectEndDatePlanned;
    private LocalDate projectEndDateActual;
    private Integer tenureOfProjectMonths;
}
