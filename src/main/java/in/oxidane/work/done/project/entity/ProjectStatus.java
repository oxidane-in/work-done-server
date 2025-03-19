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
@Table(name = "project_status", schema = "master")
public class ProjectStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_status_id")
    private int projectStatusId;

    @Column(name = "project_status_name", nullable = false, length = 50)
    private String projectStatusName;

    @Column(name = "project_status_handle", nullable = false, length = 50, unique = true)
    private String projectStatusHandle;

    @Column(name = "project_status_desc", length = 255)
    private String projectStatusDesc;

    @Column(name = "project_status_is_active", nullable = false)
    private Boolean projectStatusIsActive = true; // Default value
}
