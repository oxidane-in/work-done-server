package in.oxidane.work.done.lineitem.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.material.entity.Material;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DbConstants.LINE_ITEM_MATERIAL, schema = DbConstants.CORE_SCHEMA)
public class LineItemMaterial extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_MATERIAL_ID)
    private Long lineItemMaterialId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_MATERIAL_LINE_ITEM))
    private LineItem lineItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.MATERIAL_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_MATERIAL_MATERIAL))
    private Material material;

    @Column(name = DbConstants.CONSUMPTION_PER_UOM, precision = 10, scale = 2)
    private BigDecimal consumptionPerUom;
}
