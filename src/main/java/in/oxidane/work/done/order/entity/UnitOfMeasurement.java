package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.UNIT_OF_MEASUREMENT, schema = DbConstants.MASTER_SCHEMA)
public class UnitOfMeasurement extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.UOM_ID)
    private Long uomId;

    @Column(name = DbConstants.UOM_NAME, nullable = false, length = 50)
    private String uomName;

    @Column(name = DbConstants.UOM_SYMBOL, length = 20)
    private String uomSymbol;

    @Column(name = DbConstants.UOM_HANDLE, nullable = false, length = 50, unique = true)
    private String uomHandle;

    @Column(name = DbConstants.UOM_DESC)
    private String uomDesc;

    @Override
    protected void prePersistOrUpdate() {
        this.uomHandle = uomName.toLowerCase().replace(" ", "-");
    }
}
