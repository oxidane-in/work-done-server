package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material Type Request DTO")
public class MaterialTypeRequest {

    @Schema(description = "Name of the material type", example = "Raw Material")
    private String materialTypeName;

    @Schema(description = "Description of the material type", example = "Unprocessed materials")
    private String materialTypeDesc;
}
