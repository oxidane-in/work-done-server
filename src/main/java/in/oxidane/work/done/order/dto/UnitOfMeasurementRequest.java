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
@Schema(description = "Unit of Measurement Request DTO")
public class UnitOfMeasurementRequest {
    
    @Schema(description = "Name of the unit of measurement", example = "Meter", required = true)
    private String uomName;
    
    @Schema(description = "Symbol of the unit of measurement", example = "m")
    private String uomSymbol;
    
    @Schema(description = "Handle or unique identifier for the unit of measurement", example = "meter")
    private String uomHandle;
    
    @Schema(description = "Description of the unit of measurement", example = "Standard unit of length")
    private String uomHandleDesc;
    
    @Schema(description = "Whether the unit of measurement is active", example = "true")
    private Boolean uomHandleIsActive;
} 