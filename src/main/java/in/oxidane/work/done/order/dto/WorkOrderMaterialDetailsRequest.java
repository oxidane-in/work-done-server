package in.oxidane.work.done.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderMaterialDetailsRequest {

    private Long workOrderId;

    private Long woLineItemId;

    private Long woMaterialId;

    private BigDecimal woMaterialConsumptionPerUOM;
}
