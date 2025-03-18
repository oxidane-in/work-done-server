package in.oxidane.work.done.worker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Worker Type Request DTO")
public class WorkerTypeRequest {

    @NotBlank(message = "Worker type name is required")
    @Size(max = 50, message = "Worker type name must be less than 50 characters")
    @Schema(description = "Name of the worker type", example = "Carpenter")
    private String workerTypeName;

    @NotNull(message = "Worker type rate is required")
    @Positive(message = "Worker type rate must be positive")
    @Schema(description = "Hourly rate for the worker type", example = "25.50")
    private BigDecimal workerTypeRate;

    @NotBlank(message = "Worker type handle is required")
    @Size(max = 50, message = "Worker type handle must be less than 50 characters")
    @Schema(description = "Handle or unique identifier for the worker type", example = "carpenter_senior")
    private String workerTypeHandle;

    @Size(max = 255, message = "Worker type description must be less than 255 characters")
    @Schema(description = "Description of the worker type", example = "Senior carpenter with 5+ years experience")
    private String workerTypeDesc;

    @Schema(description = "Whether the worker type is active", example = "true")
    private Boolean workerTypeIsActive;
} 