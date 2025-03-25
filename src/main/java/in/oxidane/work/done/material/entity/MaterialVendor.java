package in.oxidane.work.done.material.entity;

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
@Table(name = DbConstants.MATERIAL_VENDOR, schema = DbConstants.MASTER_SCHEMA)
public class MaterialVendor extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_VENDOR_ID)
    private Long materialVendorId;

    @Column(name = DbConstants.MATERIAL_VENDOR_NAME, nullable = false)
    private String materialVendorName;

    @Column(name = DbConstants.MATERIAL_VENDOR_DESC)
    private String materialVendorDesc;

    @Column(name = DbConstants.MATERIAL_VENDOR_HANDLE)
    private String materialVendorHandle;

    @Override
    protected void prePersistOrUpdate() {
        this.materialVendorHandle = materialVendorName.toLowerCase().replace(" ", "-");
    }
}
