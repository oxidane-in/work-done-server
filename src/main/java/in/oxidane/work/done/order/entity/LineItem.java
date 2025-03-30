package in.oxidane.work.done.order.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = DbConstants.LINE_ITEM, schema = DbConstants.CORE_SCHEMA)
public class LineItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_ID)
    private int lineItemId;

    @Column(name = DbConstants.LINE_ITEM_NAME, nullable = false)
    private String lineItemName;

    @Column(name = DbConstants.LINE_ITEM_DESC)
    private String lineItemDesc;

    @Column(name = DbConstants.LINE_ITEM_HANDLE, nullable = false)
    private String lineItemHandle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.UOM_ID, nullable = false)
    private UnitOfMeasurement unitOfMeasurement;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.lineItemHandle = lineItemName.toLowerCase().replace(" ", "-");
    }
}
