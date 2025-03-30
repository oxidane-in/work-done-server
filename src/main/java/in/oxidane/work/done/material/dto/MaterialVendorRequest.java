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
    @Schema(description = "Name of the material vendor", example = "ABC Suppliers")
    private String materialVendorName;

    @Size(max = 255, message = "Material vendor description must be less than 500 characters")
    @Schema(description = "Description of the material vendor", example = "Supplier of building materials")
    private String materialVendorDesc;
}
