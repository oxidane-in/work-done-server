package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.constant.DbConstants;
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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DbConstants.WORK_ORDER, schema = DbConstants.CORE_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_WORK_ORDER_CODE, columnNames = DbConstants.WORK_ORDER_CODE),
    })
public class WorkOrder extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.WORK_ORDER_ID)
    private Long workOrderId;

    @Column(name = DbConstants.WORK_ORDER_CODE, nullable = false, length = 50, unique = true)
    private String workOrderCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.PROJECT_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_WO_PROJECT_ID))
    private Project project;

    @Column(name = DbConstants.WORK_ORDER_DATE, nullable = false, length = 100)
    private LocalDate workOrderDate;

    @Column(name = DbConstants.WORK_ORDER_DESC, length = 500)
    private String workOrderDesc;
}
