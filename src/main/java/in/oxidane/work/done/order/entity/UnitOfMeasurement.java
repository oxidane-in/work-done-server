package in.oxidane.work.done.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "unit_of_measurement", schema = "master")
public class UnitOfMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "uom_name", nullable = false, length = 50)
    private String uomName;

    @Column(name = "uom_symbol", length = 20)
    private String uomSymbol;

    @Column(name = "uom_handle", nullable = false, length = 50, unique = true)
    private String uomHandle;

    @Column(name = "uom_handle_desc", length = 255)
    private String uomHandleDesc;

    @Column(name = "uom_handle_is_active", nullable = false)
    private Boolean uomHandleIsActive = true;
}
