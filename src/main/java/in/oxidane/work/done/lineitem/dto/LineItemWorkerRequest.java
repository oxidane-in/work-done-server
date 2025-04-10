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
public class LineItemWorkerRequest {

    private Long lineItemId;
    private Long workerTypeId;
    private BigDecimal workerTypeHajri;
}
