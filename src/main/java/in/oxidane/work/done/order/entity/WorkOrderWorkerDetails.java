package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.WO_WORKER_DETAILS, schema = DbConstants.CORE_SCHEMA)
public class WorkOrderWorkerDetails extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WO_WORKER_DETAIL_ID)
    private Long woWorkerDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.WORK_ORDER_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WORK_ORDER_ID))
    private WorkOrder workOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.WO_LINE_ITEM_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WO_LINE_ITEM_ID))
    private WorkOrderLineItems woLineItem;

    @Column(name = DbConstants.WO_WORKER_TYPE_ID, nullable = false)
    private Integer woWorkerTypeId;

    @Column(name = DbConstants.WO_WORKER_TYPE_REQUIRED_PER_UOM, nullable = false, precision = 10, scale = 2)
    private BigDecimal woWorkerTypeRequiredPerUOM;

    @Column(name = DbConstants.WO_WORKER_TYPE_RATE_PER_HAJRI, nullable = false, precision = 10, scale = 2)
    private BigDecimal woWorkerTypeRatePerHajri;
}
