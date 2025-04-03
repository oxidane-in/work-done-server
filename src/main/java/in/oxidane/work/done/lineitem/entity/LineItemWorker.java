package in.oxidane.work.done.lineitem.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.worker.entity.WorkerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DbConstants.LINE_ITEM_WORKER, schema = DbConstants.CORE_SCHEMA)
public class LineItemWorker extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_WORKER_ID)
    private Long lineItemWorkerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_WORKER_LINE_ITEM))
    private LineItem lineItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.WORKER_TYPE_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_WORKER_WORKER_TYPE))
    private WorkerType workerType;

    @Column(name = DbConstants.WORKER_TYPE_HAJRI, precision = 10, scale = 2)
    private BigDecimal workerTypeHajri;
}
