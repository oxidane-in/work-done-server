package in.oxidane.work.done.security.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_api_mapping")
public class UserApiMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_api_mapping_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name ="user_api_mapping_api_pattern",nullable = false)
    private String apiPattern;

    @Column(name ="user_api_mapping_http_method", nullable = false)
    private String httpMethod;
}
