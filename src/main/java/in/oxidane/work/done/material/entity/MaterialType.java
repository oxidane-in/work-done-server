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
@Table(name = DbConstants.MATERIAL_TYPE, schema = DbConstants.MASTER_SCHEMA)
public class MaterialType extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_TYPE_ID)
    private Long materialTypeId;

    @Column(name = DbConstants.MATERIAL_TYPE_NAME, nullable = false)
    private String materialTypeName;

    @Column(name = DbConstants.MATERIAL_TYPE_DESC)
    private String materialTypeDesc;

    @Column(name = DbConstants.MATERIAL_TYPE_HANDLE)
    private String materialTypeHandle;

    @Override
    protected void prePersistOrUpdate() {
        this.materialTypeHandle = materialTypeName.toLowerCase().replace(" ", "-");
    }
}
