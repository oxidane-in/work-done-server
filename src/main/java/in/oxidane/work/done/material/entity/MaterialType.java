package in.oxidane.work.done.material.entity;

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
@Table(name = "material_type", schema = "work_done_dbo")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaterialType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_type_id")
    private int materialTypeId;

    @Column(name = "material_type_name", nullable = false)
    private String materialTypeName;

    @Column(name = "material_type_desc")
    private String materialTypeDesc;

    @Column(name = "material_type_handle")
    private String materialTypeHandle;
}
