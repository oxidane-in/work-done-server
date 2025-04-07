package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.lineitem.entity.LineItem;
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
@Table(name = DbConstants.WO_LINE_ITEMS, schema = DbConstants.CORE_SCHEMA)
public class WorkOrderLineItems extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WO_LINE_ITEM_ID)
    private Long woLineItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.WORK_ORDER_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WORK_ORDER_ID))
    private WorkOrder workOrderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.WO_ALLOCATED_LINE_ITEM_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WO_LINE_ITEM_ID))
    private LineItem woAllocatedLineItemId;

    @Column(name = DbConstants.WO_LINE_ITEM_QTY, nullable = false, precision = 10, scale = 2)
    private BigDecimal woLineItemQty;

    @Column(name = DbConstants.WO_LINE_ITEM_RATE, nullable = false, precision = 10, scale = 2)
    private BigDecimal woLineItemRate;

    @Column(name = DbConstants.WO_LINE_ITEM_LABOR_CONSTANT, nullable = false, precision = 10, scale = 2)
    private BigDecimal woLineItemLaborConstant;
}
