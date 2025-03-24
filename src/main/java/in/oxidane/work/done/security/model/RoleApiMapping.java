package in.oxidane.work.done.security.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role_api_mapping")
public class RoleApiMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    private String apiPattern;
    private String httpMethod;
}
