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
@Table(name = DbConstants.LINE_ITEM_HEADER, schema = DbConstants.MDM_SCHEMA,
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {DbConstants.LINE_ITEM_HEADER_HANDLE, DbConstants.LINE_ITEM_HEADER_NAME}),
    })
public class LineItemHeader extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DbConstants.LINE_ITEM_HEADER_ID)
    private Long lineItemHeaderId;

    @Column(name = DbConstants.LINE_ITEM_HEADER_NAME, nullable = false, length = 100, unique = true)
    private String lineItemHeaderName;

    @Column(name = DbConstants.LINE_ITEM_HEADER_HANDLE, nullable = false, length = 100, unique = true)
    private String lineItemHeaderHandle;

    @Column(name = DbConstants.LINE_ITEM_HEADER_DESC)
    private String lineItemHeaderDesc;

    @PrePersist
    @PreUpdate
    protected void prePersistOrUpdate() {
        this.lineItemHeaderHandle = lineItemHeaderName.toLowerCase().replace(" ", "-");
    }
}
