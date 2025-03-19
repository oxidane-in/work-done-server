package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Response DTO for Material operations.
 * Used for returning Material data to clients.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material Response DTO")
public class MaterialResponse {

    @Schema(description = "ID of the material", example = "1")
    private Integer materialId;

    @Schema(description = "Name of the material", example = "Cement")
    private String materialName;

    @Schema(description = "ID of the material manufacturer", example = "1")
    private Integer materialManufacturerId;

    @Schema(description = "Name of the material manufacturer", example = "ABC Manufacturing")
    private String materialManufacturerName;

    @Schema(description = "ID of the material vendor", example = "1")
    private Integer materialVendorId;

    @Schema(description = "Name of the material vendor", example = "XYZ Suppliers")
    private String materialVendorName;

    @Schema(description = "ID of the material type", example = "1")
    private Integer materialTypeId;

    @Schema(description = "Name of the material type", example = "Construction")
    private String materialTypeName;

    @Schema(description = "Unit of measurement for the material", example = "kg")
    private String materialUnit;

    @Schema(description = "Size of the material package", example = "50.0")
    private BigDecimal materialPackSize;

    @Schema(description = "Rate per pack of the material", example = "350.0")
    private BigDecimal materialRatePerPack;

    @Schema(description = "Rate per unit of the material", example = "7.0")
    private BigDecimal materialRatePerUnit;

    @Schema(description = "Creation timestamp", example = "2023-09-15T10:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Last update timestamp", example = "2023-09-15T10:30:00")
    private LocalDateTime updatedAt;
}
