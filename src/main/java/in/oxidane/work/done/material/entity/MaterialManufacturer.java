package in.oxidane.work.done.material.entity;

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
@Table(name = DbConstants.MATERIAL_MANUFACTURER,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_MATERIAL_MANUFACTURER_NAME, columnNames = DbConstants.MATERIAL_MANUFACTURER_NAME),
        @UniqueConstraint(name = DbConstants.UK_MATERIAL_MANUFACTURER_HANDLE, columnNames = DbConstants.MATERIAL_MANUFACTURER_HANDLE)
    })
public class MaterialManufacturer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_MANUFACTURER_ID)
    private Long materialManufacturerId;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_NAME, nullable = false, unique = true)
    private String materialManufacturerName;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_DESC)
    private String materialManufacturerDesc;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_HANDLE, nullable = false, unique = true)
    private String materialManufacturerHandle;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.materialManufacturerHandle = materialManufacturerName.toLowerCase().replace(" ", "-");
    }
}
