package in.oxidane.work.done.lineitem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemWorkerResponse {
    private Long lineItemWorkerId;
    private Long lineItemId;
    private Long workerTypeId;
    private BigDecimal workerTypeHajri;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
} 