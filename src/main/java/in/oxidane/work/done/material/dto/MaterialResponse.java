package in.oxidane.work.done.material.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import in.oxidane.work.done.order.dto.UnitOfMeasurementResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * Response DTO for Material operations.
 * Used for returning Material data to clients.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "Material Response DTO")
public class MaterialResponse extends AuditableResponse {

    @Schema(description = "ID of the material", example = "1")
    private Long materialId;

    @Schema(description = "Name of the material", example = "Cement")
    private String materialName;

    @Schema(description = "material manufacturer", example = "ABC Manufacturing")
    private MaterialManufacturerResponse materialManufacturer;

    @Schema(description = "material vendor", example = "XYZ Suppliers")
    private MaterialVendorResponse materialVendor;

    @Schema(description = "material type", example = "Construction")
    private MaterialTypeResponse materialType;

    @Schema(description = "Unit of measurement for the material", example = "kg")
    private UnitOfMeasurementResponse materialUOM;

    @Schema(description = "Size of the material package", example = "50.0")
    private BigDecimal materialPackSize;

    @Schema(description = "Rate per pack of the material", example = "350.0")
    private BigDecimal materialRatePerPack;

    @Schema(description = "Rate per unit of the material", example = "7.0")
    private BigDecimal materialRatePerUnit;
}
