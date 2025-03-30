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
@Table(name = DbConstants.MATERIAL_TYPE,
    schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(columnNames = DbConstants.MATERIAL_TYPE_NAME),
        @UniqueConstraint(columnNames = DbConstants.MATERIAL_TYPE_HANDLE)
    })
public class MaterialType extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_TYPE_ID)
    private Long materialTypeId;

    @Column(name = DbConstants.MATERIAL_TYPE_NAME, nullable = false, unique = true)
    private String materialTypeName;

    @Column(name = DbConstants.MATERIAL_TYPE_DESC)
    private String materialTypeDesc;

    @Column(name = DbConstants.MATERIAL_TYPE_HANDLE, nullable = false, unique = true)
    private String materialTypeHandle;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.materialTypeHandle = materialTypeName.toLowerCase().replace(" ", "-");
    }
}
