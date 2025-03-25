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
@Table(name = DbConstants.MATERIAL_MANUFACTURER, schema = DbConstants.MASTER_SCHEMA)
public class MaterialManufacturer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_MANUFACTURER_ID)
    private Long materialManufacturerId;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_NAME, nullable = false)
    private String materialManufacturerName;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_DESC)
    private String materialManufacturerDesc;

    @Column(name = DbConstants.MATERIAL_MANUFACTURER_HANDLE)
    private String materialManufacturerHandle;

    @Override
    protected void prePersistOrUpdate() {
        this.materialManufacturerHandle = materialManufacturerName.toLowerCase().replace(" ", "-");
    }
}
