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
@Schema(description = "Material Vendor Response DTO")
public class MaterialVendorResponse {

    @Schema(description = "Material vendor ID", example = "1")
    private Long materialVendorId;

    @Schema(description = "Name of the material vendor", example = "ABC Suppliers")
    private String materialVendorName;

    @Schema(description = "Description of the material vendor", example = "Supplier of building materials")
    private String materialVendorDesc;

    @Schema(description = "Handle or unique identifier for the vendor", example = "abc_suppliers")
    private String materialVendorHandle;
}
