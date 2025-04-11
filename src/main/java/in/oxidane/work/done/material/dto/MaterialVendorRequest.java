package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Material Vendor Request DTO")
public class MaterialVendorRequest {

    @Schema(description = "Name of the material vendor", example = "ABC Suppliers")
    private String materialVendorName;

    @Schema(description = "Description of the material vendor", example = "Supplier of building materials")
    private String materialVendorDesc;
}
