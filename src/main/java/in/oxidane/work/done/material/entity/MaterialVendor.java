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
@Table(name = DbConstants.MATERIAL_VENDOR,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(columnNames = DbConstants.MATERIAL_VENDOR_NAME),
        @UniqueConstraint(columnNames = DbConstants.MATERIAL_VENDOR_HANDLE)
    })
public class MaterialVendor extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_VENDOR_ID)
    private Long materialVendorId;

    @Column(name = DbConstants.MATERIAL_VENDOR_NAME, nullable = false, unique = true)
    private String materialVendorName;

    @Column(name = DbConstants.MATERIAL_VENDOR_DESC)
    private String materialVendorDesc;

    @Column(name = DbConstants.MATERIAL_VENDOR_HANDLE, nullable = false, unique = true)
    private String materialVendorHandle;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.materialVendorHandle = materialVendorName.toLowerCase().replace(" ", "-");
    }
}
