package in.oxidane.work.done.project.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.PROJECT_STATUS,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_PROJECT_STATUS_NAME, columnNames = DbConstants.PROJECT_STATUS_NAME),
        @UniqueConstraint(name = DbConstants.UK_PROJECT_STATUS_HANDLE, columnNames = DbConstants.PROJECT_STATUS_HANDLE)
    })
public class ProjectStatus extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_STATUS_ID)
    private Long projectStatusId;

    @Column(name = DbConstants.PROJECT_STATUS_NAME, nullable = false, length = 50, unique = true)
    private String projectStatusName;

    @Column(name = DbConstants.PROJECT_STATUS_HANDLE, nullable = false, length = 50, unique = true)
    private String projectStatusHandle;

    @Column(name = DbConstants.PROJECT_STATUS_DESC)
    private String projectStatusDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.projectStatusHandle = projectStatusName.toLowerCase().replace(" ", "-");
    }
}
