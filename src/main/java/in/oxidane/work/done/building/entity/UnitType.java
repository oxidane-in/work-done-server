package in.oxidane.work.done.building.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "unit_type", schema = "master")
public class UnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_type_id")
    private Integer unitTypeId;

    @Column(name = "unit_type_name", nullable = false, length = 100)
    private String unitTypeName;

    @Column(name = "unit_type_handle", nullable = false, length = 50, unique = true)
    private String unitTypeHandle;

    @Column(name = "unit_type_desc", length = 255)
    private String unitTypeDesc;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
