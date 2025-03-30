package in.oxidane.work.done.worker.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.WORKER_TYPE, schema = DbConstants.MDM_SCHEMA)
public class WorkerType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WORKER_TYPE_ID)
    private Long workerTypeId;

    @Column(name = DbConstants.WORKER_TYPE_NAME, nullable = false, length = 50)
    private String workerTypeName;

    @Column(name = DbConstants.WORKER_TYPE_RATE, nullable = false, precision = 10, scale = 2)
    private BigDecimal workerTypeRate;

    //TODO: handle condition where worker name is not unique
    @Column(name = DbConstants.WORKER_TYPE_HANDLE, nullable = false, length = 50)
    private String workerTypeHandle;

    @Column(name = DbConstants.WORKER_TYPE_DESC)
    private String workerTypeDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.workerTypeHandle = workerTypeName.toLowerCase().replace(" ", "-");
    }
}
