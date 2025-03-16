package in.oxidane.work.done.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material_vendor", schema = "work_done_dbo")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaterialVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_vendor_id")
    private int materialVendorId;

    @Column(name = "material_vendor_name", nullable = false)
    private String materialVendorName;

    @Column(name = "material_vendor_desc")
    private String materialVendorDesc;

    @Column(name = "material_vendor_handle")
    private String materialVendorHandle;

}
