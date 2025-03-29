package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material manufacturer request data")
public class MaterialManufacturerRequest {

    @NotBlank
    @Schema(description = "Material manufacturer name", example = "ABC Industries")
    private String materialManufacturerName;

    @Schema(description = "Material manufacturer description", example = "Leading provider of industrial materials")
    private String materialManufacturerDesc;
}
