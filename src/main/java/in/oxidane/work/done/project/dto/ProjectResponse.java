package in.oxidane.work.done.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Long projectId;
    private String projectName;
    private String projectLocation;
    private String projectCity;
    private String projectState;
    private ClientResponse customer;
    private ProjectStatusResponse projectStatus;
    private LocalDate projectStartDate;
    private LocalDate projectEndDatePlanned;
    private LocalDate projectEndDateActual;
    private String woNumber;
    private LocalDate woDate;
    private LocalDate woCompletionDate;
    private Integer tenureOfProjectMonths;
    private BigDecimal woAmount;
    private String createdBy;
    private LocalDate createdDate;
    private String lastModifiedBy;
    private LocalDate lastModifiedDate;
} 