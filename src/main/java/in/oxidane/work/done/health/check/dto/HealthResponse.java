package in.oxidane.work.done.health.check.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Health check response information")
public class HealthResponse {
    
    @Schema(description = "Service status (UP/DOWN)", example = "UP")
    private String status;
    
    @Schema(description = "Current timestamp in milliseconds", example = "1678901234567")
    private long timestamp;
    
    @Schema(description = "Service name", example = "work-done-api-service")
    private String service;
} 