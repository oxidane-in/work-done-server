package in.oxidane.work.done.order.entity;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.WO_OTHER_COST_ACTUAL, schema = DbConstants.CORE_SCHEMA)
public class WorkOrderOtherCostActual extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WO_OTHER_COST_ACTUAL_ID, nullable = false)
    private Long woOtherCostPlannedId;

    @ManyToOne
    @JoinColumn(name = DbConstants.WO_OTHER_COST_PLANNED_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WO_OTHER_COST_PLANNED_ID))
    private WorkOrderOtherCostPlanned workOrderOtherCostPlanned;

    @Column(name = DbConstants.WO_OTHER_COST_ACTUAL_AMOUNT, nullable = false, precision = 18, scale = 2)
    private BigDecimal woOtherCostPlannedAmount;

    @Column(name = DbConstants.WO_OTHER_COST_ACTUAL_REMARK, length = 500)
    private String woOtherCostPlannedRemark;
}
