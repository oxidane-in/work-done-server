package in.oxidane.work.done.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project_scope", schema = "master")
public class ProjectScope {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_scope_id")
    private int projectScopeId;

    @Column(name = "project_scope_name", nullable = false, length = 100)
    private String projectScopeName;

    @Column(name = "project_scope_handle", nullable = false, length = 50, unique = true)
    private String projectScopeHandle;

    @Column(name = "project_scope_desc", length = 255)
    private String projectScopeDesc;

    @Column(name = "project_scope_is_active", nullable = false)
    private Boolean projectScopeIsActive = true; // Default value
}
