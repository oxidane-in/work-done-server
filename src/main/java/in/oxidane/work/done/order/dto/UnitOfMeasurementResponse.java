package in.oxidane.work.done.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Unit of Measurement Response DTO")
public class UnitOfMeasurementResponse {

    @Schema(description = "Unique identifier for the unit of measurement", example = "1")
    private Long uomId;

    @Schema(description = "Name of the unit of measurement", example = "Meter")
    private String uomName;

    @Schema(description = "Symbol of the unit of measurement", example = "m")
    private String uomSymbol;

    @Schema(description = "Handle or unique identifier for the unit of measurement", example = "meter")
    private String uomHandle;

    @Schema(description = "Description of the unit of measurement", example = "Standard unit of length")
    private String uomDesc;
}
