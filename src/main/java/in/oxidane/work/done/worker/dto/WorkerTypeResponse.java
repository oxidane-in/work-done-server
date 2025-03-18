package in.oxidane.work.done.worker.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Worker Type Response DTO")
public class WorkerTypeResponse {

    @Schema(description = "Worker type ID", example = "1")
    private int workerTypeId;

    @Schema(description = "Name of the worker type", example = "Carpenter")
    private String workerTypeName;

    @Schema(description = "Hourly rate for the worker type", example = "25.50")
    private BigDecimal workerTypeRate;

    @Schema(description = "Handle or unique identifier for the worker type", example = "carpenter_senior")
    private String workerTypeHandle;

    @Schema(description = "Description of the worker type", example = "Senior carpenter with 5+ years experience")
    private String workerTypeDesc;

    @Schema(description = "Whether the worker type is active", example = "true")
    private Boolean workerTypeIsActive;
} 