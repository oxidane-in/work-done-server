package in.oxidane.work.done.project.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ProjectRequest {

    @NotBlank(message = "Project name is required")
    @Size(max = 255, message = "Project name must be less than 255 characters")
    private String projectName;

    @NotBlank(message = "Project location is required")
    @Size(max = 255, message = "Project location must be less than 255 characters")
    private String projectLocation;

    @NotBlank(message = "Project city is required")
    @Size(max = 100, message = "Project city must be less than 100 characters")
    private String projectCity;

    @NotBlank(message = "Project state is required")
    @Size(max = 100, message = "Project state must be less than 100 characters")
    private String projectState;

    @NotNull(message = "Client ID is required")
    private Long clientId;

    @NotNull(message = "Project status ID is required")
    private Long projectStatusId;

    @NotNull(message = "Project start date is required")
    private LocalDate projectStartDate;

    @NotNull(message = "Project planned end date is required")
    @FutureOrPresent(message = "Project planned end date must be in the future or present")
    private LocalDate projectEndDatePlanned;

    private LocalDate projectEndDateActual;

    @NotBlank(message = "WO number is required")
    @Size(max = 50, message = "WO number must be less than 50 characters")
    private String woNumber;

    @NotNull(message = "WO date is required")
    private LocalDate woDate;

    private LocalDate woCompletionDate;

    @NotNull(message = "Tenure of project in months is required")
    @Min(value = 1, message = "Tenure of project must be at least 1 month")
    private Integer tenureOfProjectMonths;

    @NotNull(message = "WO amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "WO amount must be greater than 0")
    @Digits(integer = 16, fraction = 2, message = "WO amount cannot exceed 16 digits in integer part and 2 digits in fraction part")
    private BigDecimal woAmount;
} 