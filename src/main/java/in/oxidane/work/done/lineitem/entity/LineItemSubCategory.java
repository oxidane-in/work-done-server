package in.oxidane.work.done.lineitem.entity;

import in.oxidane.work.done.common.constant.DbConstants;
import in.oxidane.work.done.common.entity.Auditable;
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

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.LINE_ITEM_SUB_CATEGORY, schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(name = DbConstants.UK_LINE_ITEM_SUB_CATEGORY_NAME, columnNames = DbConstants.LINE_ITEM_SUB_CATEGORY_NAME),
        @UniqueConstraint(name = DbConstants.UK_LINE_ITEM_SUB_CATEGORY_HANDLE, columnNames = DbConstants.LINE_ITEM_SUB_CATEGORY_HANDLE)
    })
public class LineItemSubCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_SUB_CATEGORY_ID)
    private Long lineItemSubCategoryId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DbConstants.LINE_ITEM_CATEGORY_ID, nullable = false, foreignKey = @ForeignKey(name = DbConstants.FK_LINE_ITEM_CATEGORY_ID))
    private LineItemCategory lineItemCategoryId;

    @Column(name = DbConstants.LINE_ITEM_SUB_CATEGORY_NAME, nullable = false, length = 100, unique = true)
    private String lineItemSubCategoryName;

    @Column(name = DbConstants.LINE_ITEM_SUB_CATEGORY_HANDLE, nullable = false, length = 100, unique = true)
    private String lineItemSubCategoryHandle;

    @Column(name = DbConstants.LINE_ITEM_SUB_CATEGORY_DESC)
    private String lineItemSubCategoryDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.lineItemSubCategoryHandle = lineItemSubCategoryName.toLowerCase().replace(" ", "-");
    }
}
