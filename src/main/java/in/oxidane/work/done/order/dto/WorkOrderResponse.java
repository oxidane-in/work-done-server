package in.oxidane.work.done.order.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import in.oxidane.work.done.project.dto.ProjectResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class WorkOrderResponse extends AuditableResponse {
    private Long workOrderId;
    private String workOrderCode;
    private ProjectResponse project;
    private LocalDate workOrderDate;
    private String workOrderDesc;
}
