package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Material name is required")
    @Size(max = 100, message = "Material name must be less than 100 characters")
    @Schema(description = "Name of the material", example = "Cement")
    private String materialName;

    @Schema(description = "ID of the material manufacturer", example = "1")
    private Integer materialManufacturerId;

    @Schema(description = "ID of the material vendor", example = "1")
    private Integer materialVendorId;

    @Schema(description = "ID of the material type", example = "1")
    private Integer materialTypeId;

    @Size(max = 20, message = "Material unit must be less than 20 characters")
    @Schema(description = "Unit of measurement for the material", example = "kg")
    private String materialUnit;

    @NotNull(message = "Material pack size is required")
    @Positive(message = "Material pack size must be positive")
    @Schema(description = "Size of the material package", example = "50.0")
    private BigDecimal materialPackSize;

    @Schema(description = "Rate per pack of the material", example = "350.0")
    private BigDecimal materialRatePerPack;

    @Schema(description = "Rate per unit of the material", example = "7.0")
    private BigDecimal materialRatePerUnit;
}
