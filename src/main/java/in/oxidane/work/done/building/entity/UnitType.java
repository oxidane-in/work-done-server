package in.oxidane.work.done.building.entity;

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
@Table(name = DbConstants.UNIT_TYPE, schema = DbConstants.MDM_SCHEMA)
public class UnitType extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.UNIT_TYPE_ID)
    private Long unitTypeId;

    @Column(name = DbConstants.UNIT_TYPE_NAME, nullable = false, length = 100)
    private String unitTypeName;

    @Column(name = DbConstants.UNIT_TYPE_HANDLE, nullable = false, length = 50, unique = true)
    private String unitTypeHandle;

    @Column(name = DbConstants.UNIT_TYPE_DESC)
    private String unitTypeDesc;

    @PrePersist
    @PreUpdate
    public void prePersistOrUpdate() {
        this.unitTypeHandle = unitTypeName.toLowerCase().replace(" ", "-");
    }
}
