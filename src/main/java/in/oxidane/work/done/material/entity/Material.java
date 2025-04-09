package in.oxidane.work.done.material.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.MATERIAL, schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_MATERIAL_NAME, columnNames = DbConstants.MATERIAL_NAME)
    })
public class Material extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.MATERIAL_ID)
    private Long materialId;

    @Column(name = DbConstants.MATERIAL_NAME, nullable = false, unique = true)
    private String materialName;

    @ManyToOne
    @JoinColumn(name = DbConstants.MATERIAL_MANUFACTURER_ID,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_MANUFACTURER_ID))
    private MaterialManufacturer materialManufacturer;

    @ManyToOne
    @JoinColumn(name = DbConstants.MATERIAL_VENDOR_ID,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_VENDOR_ID))
    private MaterialVendor materialVendor;

    @ManyToOne
    @JoinColumn(name = DbConstants.MATERIAL_TYPE_ID,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_TYPE_ID))
    private MaterialType materialType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.MATERIAL_UNIT, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_UOM_ID))
    private UnitOfMeasurement materialUOM;

    @Column(name = DbConstants.MATERIAL_PACK_SIZE, nullable = false, precision = 10, scale = 2)
    private BigDecimal materialPackSize;

    @Column(name = DbConstants.MATERIAL_RATE_PER_PACK, nullable = false, precision = 10, scale = 2)
    private BigDecimal materialRatePerPack;

    @Column(name = DbConstants.MATERIAL_RATE_PER_UNIT, nullable = false, precision = 10, scale = 2)
    private BigDecimal materialRatePerUnit;

    @PreUpdate
    @PrePersist
    private void prePersist() {
        if (materialRatePerPack != null && materialPackSize != null) {
            materialRatePerUnit = materialRatePerPack.divide(materialPackSize, 2, RoundingMode.HALF_UP);
        }
    }
}
