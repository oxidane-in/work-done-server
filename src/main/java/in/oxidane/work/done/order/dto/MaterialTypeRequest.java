package in.oxidane.work.done.order.dto;

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

    @NotBlank(message = "Material type name is required")
    @Size(max = 100, message = "Material type name must be less than 100 characters")
    @Schema(description = "Name of the material type", example = "Raw Material")
    private String materialTypeName;

    @Size(max = 500, message = "Material type description must be less than 500 characters")
    @Schema(description = "Description of the material type", example = "Unprocessed materials")
    private String materialTypeDesc;

    @Size(max = 50, message = "Material type handle must be less than 50 characters")
    @Schema(description = "Handle or unique identifier for the type", example = "raw_material")
    private String materialTypeHandle;
}
