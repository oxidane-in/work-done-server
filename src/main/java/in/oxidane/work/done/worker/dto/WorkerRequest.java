package in.oxidane.work.done.worker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerRequest {
    private String workerName;
    private Long workerTypeId;
    private BigDecimal workerRate;
    private String workerBankAccount;
    private String workerIFSC;
    private LocalDate workerBirthDate;
    private String workerMobileNumber;
    private String workerState;
    private LocalDate workerDOJ;
}
