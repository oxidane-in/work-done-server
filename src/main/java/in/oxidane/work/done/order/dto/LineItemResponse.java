package in.oxidane.work.done.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Line Item Response DTO")
public class LineItemResponse {
    
    @Schema(description = "Unique identifier of the line item", example = "1")
    private Integer lineItemId;
    
    @Schema(description = "Name of the line item", example = "Steel Rebar")
    private String lineItemName;
    
    @Schema(description = "Description of the line item", example = "High tensile strength steel rebar for reinforcement")
    private String lineItemDesc;
    
    @Schema(description = "Handle of the line item", example = "steel-rebar")
    private String lineItemHandle;
    
    @Schema(description = "Unit of measurement details")
    private UnitOfMeasurementResponse unitOfMeasurement;
    
    @Schema(description = "When the line item was created", example = "2025-03-24T14:30:00")
    private LocalDateTime createdOn;
    
    @Schema(description = "Who created the line item", example = "admin")
    private String createdBy;
    
    @Schema(description = "When the line item was last updated", example = "2025-03-25T09:15:00")
    private LocalDateTime updatedOn;
    
    @Schema(description = "Who last updated the line item", example = "admin")
    private String updatedBy;
} 