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
@Schema(description = "Unit Type Request DTO")
public class UnitTypeRequest {

    @Schema(description = "Name of the unit type", example = "Apartment")
    private String unitTypeName;

    @Schema(description = "Description of the unit type", example = "Residential apartment unit")
    private String unitTypeDesc;
}
