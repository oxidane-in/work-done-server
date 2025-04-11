package in.oxidane.work.done.building.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Unit Type Response DTO")
public class UnitTypeResponse {

    @Schema(description = "Unique identifier for the unit type", example = "1")
    private Long unitTypeId;

    @Schema(description = "Name of the unit type", example = "Apartment")
    private String unitTypeName;

    @Schema(description = "Handle or unique identifier for the unit type", example = "apartment")
    private String unitTypeHandle;

    @Schema(description = "Description of the unit type", example = "Residential apartment unit")
    private String unitTypeDesc;
}
