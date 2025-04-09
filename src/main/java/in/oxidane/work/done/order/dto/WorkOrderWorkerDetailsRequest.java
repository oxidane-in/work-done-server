package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkOrderWorkerDetailsRequest extends AuditableResponse {

    private Long workOrderId;

    private Long woLineItemId;

    private Long woWorkerTypeId;

    private BigDecimal woWorkerTypeRequiredPerUOM;

    private BigDecimal woWorkerTypeRatePerHajri;
}
