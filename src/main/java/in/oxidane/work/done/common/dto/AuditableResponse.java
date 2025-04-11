package in.oxidane.work.done.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AuditableResponse {

    @Schema(description = "When the line item was created", example = "2025-03-24T14:30:00")
    private LocalDateTime createdOn;

    @Schema(description = "Who created the line item", example = "admin")
    private String createdBy;

    @Schema(description = "When the line item was last updated", example = "2025-03-25T09:15:00")
    private LocalDateTime updatedOn;

    @Schema(description = "Who last updated the line item", example = "admin")
    private String updatedBy;
}
