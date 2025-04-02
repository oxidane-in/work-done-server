package in.oxidane.work.done.project.entity;

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
import java.time.LocalDate;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.PROJECT, schema = DbConstants.CORE_SCHEMA)
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_ID)
    private Long projectId;

    @Column(name = DbConstants.PROJECT_NAME, nullable = false)
    private String projectName;

    @Column(name = DbConstants.PROJECT_LOCATION, nullable = false)
    private String projectLocation;

    @Column(name = DbConstants.PROJECT_CITY, nullable = false, length = 100)
    private String projectCity;

    @Column(name = DbConstants.PROJECT_STATE, nullable = false, length = 100)
    private String projectState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.CLIENT_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_PROJECT_CLIENT))
    private Client customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.PROJECT_STATUS_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_PROJECT_PROJECT_STATUS))
    private ProjectStatus projectStatus;

    @Column(name = DbConstants.PROJECT_START_DATE, nullable = false)
    private LocalDate projectStartDate;

    @Column(name = DbConstants.PROJECT_END_DATE_PLANNED, nullable = false)
    private LocalDate projectEndDatePlanned;

    @Column(name = DbConstants.PROJECT_END_DATE_ACTUAL)
    private LocalDate projectEndDateActual;

    @Column(name = DbConstants.WO_NUMBER, nullable = false, unique = true, length = 50)
    private String woNumber;

    @Column(name = DbConstants.WO_DATE, nullable = false)
    private LocalDate woDate;

    @Column(name = DbConstants.WO_COMPLETION_DATE)
    private LocalDate woCompletionDate;

    @Column(name = DbConstants.TENURE_OF_PROJECT_MONTHS, nullable = false)
    private Integer tenureOfProjectMonths;

    @Column(name = DbConstants.WO_AMOUNT, nullable = false, precision = 18, scale = 2)
    private BigDecimal woAmount;
}
