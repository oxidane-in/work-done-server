package in.oxidane.work.done.worker.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.WORKER, schema = DbConstants.MDM_SCHEMA,
uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_WORKER_NAME, columnNames = DbConstants.WORKER_NAME),
        @UniqueConstraint(name = DbConstants.UK_WORKER_MOBILE_NUMBER, columnNames = DbConstants.WORKER_MOBILE_NUMBER)
    })
public class Worker extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WORKER_ID)
    private Long workerId;

    @Column(name = DbConstants.WORKER_NAME, nullable = false)
    private String workerName;

    @ManyToOne
    @JoinColumn(name = DbConstants.WORKER_TYPE_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WORKER_TYPE))
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
