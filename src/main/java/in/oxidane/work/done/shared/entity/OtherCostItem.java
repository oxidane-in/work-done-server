package in.oxidane.work.done.shared.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.OTHER_COST_ITEM, schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_OTHER_COST_ITEM_NAME, columnNames = DbConstants.OTHER_COST_ITEM_NAME),
        @UniqueConstraint(name = DbConstants.UK_OTHER_COST_ITEM_HANDLE, columnNames = DbConstants.OTHER_COST_ITEM_HANDLE)
    })
public class OtherCostItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.OTHER_COST_ITEM_ID)
    private Long otherCostItemId;

    @Column(name = DbConstants.OTHER_COST_ITEM_NAME, nullable = false, unique = true, length = 200)
    private String otherCostItemName;

    @Column(name = DbConstants.OTHER_COST_ITEM_DESC, length = 500)
    private String otherCostItemDesc;

    @Column(name = DbConstants.OTHER_COST_ITEM_HANDLE, nullable = false, unique = true, length = 100)
    private String otherCostItemHandle;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.otherCostItemHandle = otherCostItemName.toLowerCase().replace(" ", "-");
    }
}
