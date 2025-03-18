package in.oxidane.work.done.worker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "worker_type", schema = "master")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class WorkerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_type_id")
    private int workerTypeId;

    @Column(name = "worker_type_name", nullable = false)
    private String workerTypeName;

    @Column(name = "worker_type_rate", nullable = false, precision = 10, scale = 2)
    private BigDecimal workerTypeRate;

    @Column(name = "worker_type_handle", nullable = false, unique = true)
    private String workerTypeHandle;

    @Column(name = "worker_type_desc")
    private String workerTypeDesc;

    @Column(name = "worker_type_is_active", columnDefinition = "boolean default true")
    private Boolean workerTypeIsActive;
}
