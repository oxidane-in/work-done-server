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
@Table(name = DbConstants.PROJECT_SCOPE,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_PROJECT_SCOPE_NAME, columnNames = DbConstants.PROJECT_SCOPE_NAME),
        @UniqueConstraint(name = DbConstants.UK_PROJECT_SCOPE_HANDLE, columnNames = DbConstants.PROJECT_SCOPE_HANDLE)
    })
public class ProjectScope extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_SCOPE_ID)
    private Long projectScopeId;

    @Column(name = DbConstants.PROJECT_SCOPE_NAME, nullable = false, length = 100, unique = true)
    private String projectScopeName;

    @Column(name = DbConstants.PROJECT_SCOPE_HANDLE, nullable = false, length = 100, unique = true)
    private String projectScopeHandle;

    @Column(name = DbConstants.PROJECT_SCOPE_DESC)
    private String projectScopeDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.projectScopeHandle = projectScopeName.toLowerCase().replace(" ", "-");
    }
}
