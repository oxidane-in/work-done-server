package in.oxidane.work.done.project.entity;


import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.shared.entity.OtherCostItem;
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
@Table(name = DbConstants.PROJECT_OTHER_COST_PLANNED, schema = DbConstants.CORE_SCHEMA)
public class ProjectOtherCostPlanned extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_OTHER_COST_PLANNED_ID, nullable = false)
    private Long projectOtherCostPlannedId;

    @ManyToOne
    @JoinColumn(name = DbConstants.PROJECT_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_PROJECT_ID))
    private Project project;

    @ManyToOne
    @JoinColumn(name = DbConstants.OTHER_COST_ITEM_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_OTHER_COST_ITEM_ID))
    private OtherCostItem otherCostItem;

    @Column(name = DbConstants.PROJECT_OTHER_COST_PLANNED_AMOUNT, nullable = false, precision = 18, scale = 2)
    private BigDecimal projectOtherCostPlannedAmount;

    @Column(name = DbConstants.PROJECT_OTHER_COST_PLANNED_REMARK, length = 500)
    private String projectOtherCostPlannedRemark;
}
