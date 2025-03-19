package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material Type Response DTO")
public class MaterialTypeResponse {

    @Schema(description = "Material type ID", example = "1")
    private int materialTypeId;

    @Schema(description = "Name of the material type", example = "Raw Material")
    private String materialTypeName;

    @Schema(description = "Description of the material type", example = "Unprocessed materials")
    private String materialTypeDesc;

    @Schema(description = "Handle or unique identifier for the type", example = "raw_material")
    private String materialTypeHandle;
}

