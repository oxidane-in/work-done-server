package in.oxidane.work.done.security.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role_api_mapping")
public class RoleApiMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_api_mapping_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name = "role_api_mapping_api_pattern")
    private String apiPattern;

    @Column(name = "role_api_mapping_http_method")
    private String httpMethod;
}
