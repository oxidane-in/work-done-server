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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DbConstants.CUSTOMER, schema = DbConstants.CORE_SCHEMA)
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.CUSTOMER_ID)
    private Long customerId;

    @Column(name = DbConstants.CUSTOMER_NAME, nullable = false, length = 100)
    private String customerName;

    @Column(name = DbConstants.CUSTOMER_CONTACT_PERSON, length = 100)
    private String customerContactPerson;

    @Column(name = DbConstants.CUSTOMER_CONTACT_NUMBER, length = 15)
    private String customerContactNumber;

    @Column(name = DbConstants.CUSTOMER_EMAIL, length = 100)
    private String customerEmail;

    @Column(name = DbConstants.CUSTOMER_ADDRESS, columnDefinition = "TEXT")
    private String customerAddress;

    @Column(name = DbConstants.CUSTOMER_HANDLE, nullable = false, length = 50, unique = true)
    private String customerHandle;

    @Column(name = DbConstants.CUSTOMER_DESC)
    private String customerDesc;

    @Override
    protected void prePersistOrUpdate() {
        this.customerHandle = customerName.toLowerCase().replace(" ", "-");
    }
}
