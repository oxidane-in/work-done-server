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
@Table(name = "material_manufacturer", schema = "work_done_dbo")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MaterialManufacturer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "material_manufacturer_id")
private int materialManufacturerId;

@Column(name = "material_manufacturer_name", nullable = false)
private String materialManufacturerName;

@Column(name = "material_manufacturer_desc")
private String materialManufacturerDesc;

@Column(name = "material_manufacturer_handle")
private String materialManufacturerHandle;


}
