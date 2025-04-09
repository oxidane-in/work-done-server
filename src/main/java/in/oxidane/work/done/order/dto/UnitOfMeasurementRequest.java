package in.oxidane.work.done.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Unit of Measurement Request DTO")
public class UnitOfMeasurementRequest {

    @Schema(description = "Name of the unit of measurement", example = "Meter")
    private String uomName;

    @Schema(description = "Symbol of the unit of measurement", example = "m")
    private String uomSymbol;

    @Schema(description = "Description of the unit of measurement", example = "Standard unit of length")
    private String uomDesc;
}
