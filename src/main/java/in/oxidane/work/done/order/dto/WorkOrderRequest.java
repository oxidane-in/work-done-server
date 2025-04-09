package in.oxidane.work.done.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderRequest {

    private String workOrderCode;

    private Long projectId;

    private LocalDate workOrderDate;

    private String workOrderDesc;
}
