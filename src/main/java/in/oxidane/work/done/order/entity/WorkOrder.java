package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.project.entity.Project;
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
@Table(name = DbConstants.WORK_ORDER, schema = DbConstants.CORE_SCHEMA)
public class WorkOrder extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WORK_ORDER_ID)
    private Long workOrderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.PROJECT_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_WORK_ORDER_PROJECT))
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_WORK_ORDER_LINE_ITEM))
    private LineItem lineItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.UOM_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_WORK_ORDER_UOM))
    private UnitOfMeasurement unitOfMeasurement;

    @Column(name = DbConstants.QUANTITY, nullable = false, precision = 18, scale = 2)
    private BigDecimal quantity;

    @Column(name = DbConstants.RATE, nullable = false, precision = 18, scale = 2)
    private BigDecimal rate;

    @Column(name = DbConstants.TOTAL_AMOUNT, nullable = false, precision = 18, scale = 2, insertable = false, updatable = false)
    private BigDecimal totalAmount;
}
