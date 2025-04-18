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
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entity class representing a project.
 * <p>
 * This class is used to map the project table in the database.
 * It contains various attributes related to a project such as project code, name, location, status, etc.
 * </p>
 */
@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.PROJECT, schema = DbConstants.CORE_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_PROJECT_CODE, columnNames = DbConstants.PROJECT_CODE),
        @UniqueConstraint(name = DbConstants.UK_PROJECT_NAME, columnNames = DbConstants.PROJECT_NAME),
    })
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_ID)
    private Long projectId;

    @Column(name = DbConstants.PROJECT_CODE, unique = true)
    private String projectCode;

    @Column(name = DbConstants.PROJECT_NAME, nullable = false, unique = true)
    private String projectName;

    @Column(name = DbConstants.PROJECT_LOCATION, nullable = false)
    private String projectLocation;

    @Column(name = DbConstants.PROJECT_CITY, nullable = false, length = 100)
    private String projectCity;

    @Column(name = DbConstants.PROJECT_STATE, nullable = false, length = 100)
    private String projectState;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.CLIENT_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_PROJECT_CLIENT_ID))
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.PROJECT_STATUS_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_PROJECT_PROJECT_STATUS_ID))
    private ProjectStatus projectStatus;

    @Column(name = DbConstants.PROJECT_START_DATE, nullable = false)
    private LocalDate projectStartDate;

    @Column(name = DbConstants.PROJECT_END_DATE_PLANNED, nullable = false)
    private LocalDate projectEndDatePlanned;

    @Column(name = DbConstants.PROJECT_END_DATE_ACTUAL)
    private LocalDate projectEndDateActual;

    @Column(name = DbConstants.TENURE_OF_PROJECT_MONTHS, nullable = false)
    private Integer tenureOfProjectMonths;
}
