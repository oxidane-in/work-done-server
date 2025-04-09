package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request DTO for Material operations.
 * Used for creating and updating Material entities.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material Request DTO")
public class MaterialRequest {

    @Schema(description = "Name of the material", example = "Cement")
    private String materialName;

    @Schema(description = "ID of the material manufacturer", example = "1")
    private Long materialManufacturerId;

    @Schema(description = "ID of the material vendor", example = "1")
    private Long materialVendorId;

    @Schema(description = "ID of the material type", example = "1")
    private Long materialTypeId;

    @Schema(description = "Unit of measurement for the material", example = "kg")
    private Long materialUOMId;

    @Schema(description = "Size of the material package", example = "50.0")
    private BigDecimal materialPackSize;

    @Schema(description = "Rate per pack of the material", example = "350.0")
    private BigDecimal materialRatePerPack;

    @Schema(description = "Rate per unit of the material", example = "7.0")
    private BigDecimal materialRatePerUnit;
}
