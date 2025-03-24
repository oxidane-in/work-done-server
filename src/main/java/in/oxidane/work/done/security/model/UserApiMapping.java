package in.oxidane.work.done.security.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_api_mapping")
public class UserApiMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String apiPattern;

    @Column(nullable = false)
    private String httpMethod;
}
