package in.oxidane.work.done.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {

    private String projectCode;
    private String projectName;
    private String projectLocation;
    private String projectCity;
    private String projectState;
    private Long clientId;
    private Long projectStatusId;
    private LocalDate projectStartDate;
    private LocalDate projectEndDatePlanned;
    private LocalDate projectEndDateActual;
    private Integer tenureOfProjectMonths;
}
