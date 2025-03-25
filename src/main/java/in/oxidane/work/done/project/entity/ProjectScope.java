package in.oxidane.work.done.project.entity;

import in.oxidane.work.done.common.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.PROJECT_SCOPE, schema = DbConstants.MASTER_SCHEMA)
public class ProjectScope extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_SCOPE_ID)
    private Long projectScopeId;

    @Column(name = DbConstants.PROJECT_SCOPE_NAME, nullable = false, length = 100)
    private String projectScopeName;

    @Column(name = DbConstants.PROJECT_SCOPE_HANDLE, nullable = false, length = 50, unique = true)
    private String projectScopeHandle;

    @Column(name = DbConstants.PROJECT_SCOPE_DESC)
    private String projectScopeDesc;

    @Override
    protected void prePersistOrUpdate() {
        this.projectScopeHandle = projectScopeName.toLowerCase().replace(" ", "-");
    }
}
