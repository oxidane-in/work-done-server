package in.oxidane.work.done.lineitem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Line Item Request DTO")
public class LineItemRequest {

    @NotBlank(message = "Line item name is required")
    @Size(max = 100, message = "Line item name must be less than 100 characters")
    @Schema(description = "Name of the line item", example = "Steel Rebar")
    private String lineItemName;

    @Size(max = 255, message = "Line item description must be less than 255 characters")
    @Schema(description = "Description of the line item", example = "High tensile strength steel rebar for reinforcement")
    private String lineItemDesc;

    @Size(max = 50, message = "Line item handle must be less than 50 characters")
    @Schema(description = "Handle of the line item (will be auto-generated if not provided)", example = "steel-rebar")
    private String lineItemHandle;

    @NotNull(message = "Unit of measurement ID is required")
    @Schema(description = "ID of the unit of measurement", example = "1")
    private Long unitOfMeasurementId;
}
