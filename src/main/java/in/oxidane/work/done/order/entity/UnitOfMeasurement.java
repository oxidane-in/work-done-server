package in.oxidane.work.done.order.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.UNIT_OF_MEASUREMENT,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_UOM_NAME, columnNames = DbConstants.UOM_NAME),
        @UniqueConstraint(name = DbConstants.UK_UOM_SYMBOL, columnNames = DbConstants.UOM_SYMBOL),
        @UniqueConstraint(name = DbConstants.UK_UOM_HANDLE, columnNames = DbConstants.UOM_HANDLE)
    })
public class UnitOfMeasurement extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.UOM_ID)
    private Long uomId;

    @Column(name = DbConstants.UOM_NAME, nullable = false, length = 50, unique = true)
    private String uomName;

    @Column(name = DbConstants.UOM_SYMBOL, length = 20, unique = true)
    private String uomSymbol;

    @Column(name = DbConstants.UOM_HANDLE, nullable = false, length = 50, unique = true)
    private String uomHandle;

    @Column(name = DbConstants.UOM_DESC)
    private String uomDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.uomHandle = uomName.toLowerCase().replace(" ", "-");
    }
}
