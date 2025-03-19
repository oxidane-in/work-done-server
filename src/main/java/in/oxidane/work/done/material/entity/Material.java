package in.oxidane.work.done.material.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "material", schema = "core")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private int materialId;

    @Column(name = "material_name", nullable = false)
    private String materialName;

    @ManyToOne
    @JoinColumn(name = "material_manufacturer_id", referencedColumnName = "material_manufacturer_id")
    private MaterialManufacturer materialManufacturer;

    @ManyToOne
    @JoinColumn(name = "material_vendor_id", referencedColumnName = "material_vendor_id")
    private MaterialVendor materialVendor;

    @ManyToOne
    @JoinColumn(name = "material_type_id", referencedColumnName = "material_type_id")
    private MaterialType materialType;

    @Column(name = "material_unit")
    private String materialUnit;

    @Column(name = "material_pack_size", nullable = false)
    private BigDecimal materialPackSize;

    @Column(name = "material_rate_per_pack")
    private BigDecimal materialRatePerPack;

    @Column(name = "material_rate_per_unit")
    private BigDecimal materialRatePerUnit;
}
