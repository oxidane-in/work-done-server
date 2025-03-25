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
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.PROJECT_STATUS, schema = DbConstants.MASTER_SCHEMA)
public class ProjectStatus extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.PROJECT_STATUS_ID)
    private Long projectStatusId;

    @Column(name = DbConstants.PROJECT_STATUS_NAME, nullable = false, length = 50)
    private String projectStatusName;

    @Column(name = DbConstants.PROJECT_STATUS_HANDLE, nullable = false, length = 50, unique = true)
    private String projectStatusHandle;

    @Column(name = DbConstants.PROJECT_STATUS_DESC)
    private String projectStatusDesc;

    @Override
    protected void prePersistOrUpdate() {
        this.projectStatusHandle = projectStatusName.toLowerCase().replace(" ", "-");
    }
}
