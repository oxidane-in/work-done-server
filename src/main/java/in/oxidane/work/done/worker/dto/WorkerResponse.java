package in.oxidane.work.done.worker.dto;

import in.oxidane.work.done.common.dto.AuditableResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerResponse extends AuditableResponse {
    private Long workerId;
    private String workerName;
    private WorkerTypeResponse workerType;
    private BigDecimal workerRate;
    private String workerBankAccount;
    private String workerIFSC;
    private LocalDate workerBirthDate;
    private String workerMobileNumber;
    private String workerState;
    private LocalDate workerDOJ;
}
