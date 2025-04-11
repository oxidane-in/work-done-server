package in.oxidane.work.done.lineitem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Name of the line item", example = "Steel Rebar")
    private String lineItemName;

    @Schema(description = "Description of the line item", example = "High tensile strength steel rebar for reinforcement")
    private String lineItemDesc;

    @Schema(description = "Handle of the line item (will be auto-generated if not provided)", example = "steel-rebar")
    private String lineItemHandle;

    @Schema(description = "ID of the unit of measurement", example = "1")
    private Long unitOfMeasurementId;
}
