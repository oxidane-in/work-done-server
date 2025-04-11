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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.CLIENT,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_CLIENT_NAME, columnNames = DbConstants.CLIENT_NAME),
        @UniqueConstraint(name = DbConstants.UK_CLIENT_HANDLE, columnNames = DbConstants.CLIENT_HANDLE)
    })
public class Client extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.CLIENT_ID)
    private Long clientId;

    @Column(name = DbConstants.CLIENT_NAME, nullable = false, length = 100)
    private String clientName;

    @Column(name = DbConstants.CLIENT_CONTACT_PERSON, length = 100)
    private String clientContactPerson;

    @Column(name = DbConstants.CLIENT_CONTACT_NUMBER, length = 15)
    private String clientContactNumber;

    @Column(name = DbConstants.CLIENT_EMAIL, length = 100)
    private String clientEmail;

    @Column(name = DbConstants.CLIENT_ADDRESS, columnDefinition = "TEXT")
    private String clientAddress;

    @Column(name = DbConstants.CLIENT_HANDLE, nullable = false, length = 100, unique = true)
    private String clientHandle;

    @Column(name = DbConstants.CLIENT_DESC)
    private String clientDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.clientHandle = clientName.toLowerCase().replace(" ", "-");
    }
}
