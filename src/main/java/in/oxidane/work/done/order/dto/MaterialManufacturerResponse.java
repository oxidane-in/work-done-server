package in.oxidane.work.done.order.dto;

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
    private int id;
    
    @Schema(description = "Material manufacturer name", example = "ABC Industries")
    private String name;
    
    @Schema(description = "Material manufacturer description", example = "Leading provider of industrial materials")
    private String description;
    
    @Schema(description = "Material manufacturer handle or code", example = "ABC-IND")
    private String handle;
} 