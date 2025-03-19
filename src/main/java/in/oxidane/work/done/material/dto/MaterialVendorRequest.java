package in.oxidane.work.done.material.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Material vendor name is required")
    @Size(max = 100, message = "Material vendor name must be less than 100 characters")
    @Schema(description = "Name of the material vendor", example = "ABC Suppliers")
    private String materialVendorName;

    @Size(max = 500, message = "Material vendor description must be less than 500 characters")
    @Schema(description = "Description of the material vendor", example = "Supplier of building materials")
    private String materialVendorDesc;

    @Size(max = 50, message = "Material vendor handle must be less than 50 characters")
    @Schema(description = "Handle or unique identifier for the vendor", example = "abc_suppliers")
    private String materialVendorHandle;
}
