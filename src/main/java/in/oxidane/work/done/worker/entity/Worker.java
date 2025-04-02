package in.oxidane.work.done.worker.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = DbConstants.WORKER, schema = DbConstants.MDM_SCHEMA)
@Getter
@Setter
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WORKER_ID)
    private Long workerId;

    @Column(name = DbConstants.WORKER_NAME, nullable = false, length = 255)
    private String workerName;

    @ManyToOne
    @JoinColumn(name = DbConstants.WORKER_TYPE_ID, nullable = false)
    private WorkerType workerType;

    @Column(name = DbConstants.WORKER_RATE, nullable = false, precision = 10, scale = 2)
    private BigDecimal workerRate;

    @Column(name = DbConstants.WORKER_BANK_ACCOUNT, nullable = false, length = 20)
    private String workerBankAccount;

    @Column(name = DbConstants.WORKER_IFSC, nullable = false, length = 11)
    private String workerIFSC;

    @Column(name = DbConstants.WORKER_BIRTH_DATE, nullable = false)
    private LocalDate workerBirthDate;

    @Column(name = DbConstants.WORKER_MOBILE_NUMBER, nullable = false, length = 15)
    private String workerMobileNumber;

    @Column(name = DbConstants.WORKER_STATE, nullable = false, length = 100)
    private String workerState;

    @Column(name = DbConstants.WORKER_DOJ, nullable = false)
    private LocalDate workerDOJ;
}
