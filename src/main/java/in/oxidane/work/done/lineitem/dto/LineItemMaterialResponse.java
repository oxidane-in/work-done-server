package in.oxidane.work.done.lineitem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemMaterialResponse {
    private Long lineItemMaterialId;
    private Long lineItemId;
    private Long materialId;
    private String materialUnit;
    private BigDecimal materialRate;
    private BigDecimal consumptionPerUom;
} 