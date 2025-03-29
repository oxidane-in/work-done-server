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
@Schema(description = "Material manufacturer response data")
public class MaterialManufacturerResponse {

    @Schema(description = "Material manufacturer ID", example = "1")
    private Long materialManufacturerId;

    @Schema(description = "Material manufacturer name", example = "ABC Industries")
    private String materialManufacturerName;

    @Schema(description = "Material manufacturer description", example = "Leading provider of industrial materials")
    private String materialManufacturerDesc;

    @Schema(description = "Material manufacturer handle or code", example = "ABC-IND")
    private String materialManufacturerHandle;
}
