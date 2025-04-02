package in.oxidane.work.done.lineitem.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.LINE_ITEM_CATEGORY, schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {DbConstants.LINE_ITEM_CATEGORY_HANDLE, DbConstants.LINE_ITEM_CATEGORY_NAME}),
    })
public class LineItemCategory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_CATEGORY_ID)
    private Long lineItemCategoryId;

    @Column(name = DbConstants.LINE_ITEM_CATEGORY_NAME, nullable = false, length = 100, unique = true)
    private String lineItemCategoryName;

    @Column(name = DbConstants.LINE_ITEM_CATEGORY_HANDLE, nullable = false, length = 100, unique = true)
    private String lineItemCategoryHandle;

    @Column(name = DbConstants.LINE_ITEM_CATEGORY_DESC)
    private String lineItemCategoryDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.lineItemCategoryHandle = lineItemCategoryName.toLowerCase().replace(" ", "-");
    }

}
