package in.oxidane.work.done.material.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


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
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_MANUFACTURER))
    private MaterialManufacturer materialManufacturer;

    @ManyToOne
    @JoinColumn(name = DbConstants.MATERIAL_VENDOR_ID,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_VENDOR))
    private MaterialVendor materialVendor;

    @ManyToOne
    @JoinColumn(name = DbConstants.MATERIAL_TYPE_ID,
        foreignKey = @ForeignKey(name = DbConstants.FK_MATERIAL_MATERIAL_TYPE))
    private MaterialType materialType;

    @Column(name = DbConstants.MATERIAL_UNIT)
    private String materialUnit;

    @Column(name = DbConstants.MATERIAL_PACK_SIZE, nullable = false)
    private BigDecimal materialPackSize;

    @Column(name = DbConstants.MATERIAL_RATE_PER_PACK)
    private BigDecimal materialRatePerPack;

    @Column(name = DbConstants.MATERIAL_RATE_PER_UNIT)
    private BigDecimal materialRatePerUnit;
}
