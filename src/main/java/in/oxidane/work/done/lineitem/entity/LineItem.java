package in.oxidane.work.done.lineitem.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
import in.oxidane.work.done.order.entity.UnitOfMeasurement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.LINE_ITEM, schema = DbConstants.CORE_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_LINE_ITEM_NAME, columnNames = DbConstants.LINE_ITEM_NAME),
        @UniqueConstraint(name = DbConstants.UK_LINE_ITEM_HANDLE, columnNames = DbConstants.LINE_ITEM_HANDLE)
    })
public class LineItem extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_ID)
    private Long lineItemId;

    @Column(name = DbConstants.LINE_ITEM_NAME, nullable = false, unique = true)
    private String lineItemName;

    @Column(name = DbConstants.LINE_ITEM_DESC)
    private String lineItemDesc;

    @Column(name = DbConstants.LINE_ITEM_HANDLE, nullable = false, unique = true)
    private String lineItemHandle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_HEADER_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_HEADER))
    private LineItemHeader lineItemHeader;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_CATEGORY_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_CATEGORY))
    private LineItemCategory lineItemCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_SUB_CATEGORY_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_SUB_CATEGORY))
    private LineItemSubCategory lineItemSubCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.UOM_ID, nullable = false,
        foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_UOM))
    private UnitOfMeasurement unitOfMeasurement;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.lineItemHandle = lineItemName.toLowerCase().replace(" ", "-");
    }
}
