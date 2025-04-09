package in.oxidane.work.done.lineitem.dto;

import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Line Item Response DTO")
public class LineItemResponse {

    @Schema(description = "Unique identifier of the line item", example = "1")
    private Long lineItemId;

    @Schema(description = "Name of the line item", example = "Steel Rebar")
    private String lineItemName;

    @Schema(description = "Description of the line item", example = "High tensile strength steel rebar for reinforcement")
    private String lineItemDesc;

    @Schema(description = "Handle of the line item", example = "steel-rebar")
    private String lineItemHandle;

    @Schema(description = "Unit of measurement details")
    private UnitOfMeasurementResponse unitOfMeasurement;
}
