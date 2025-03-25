package in.oxidane.work.done.common.entity;

import in.oxidane.work.done.common.DbConstants;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @NotNull
    @CreatedBy
    @Column(name = DbConstants.CREATED_BY, nullable = false, updatable = false)
    private String createdBy;

    @NotNull
    @CreatedDate
    @Column(name = DbConstants.CREATED_ON, nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedBy
    @Column(name = DbConstants.UPDATED_BY, insertable = false)
    private String updatedBy;

    @LastModifiedDate
    @Column(name = DbConstants.UPDATED_ON, insertable = false)
    private LocalDateTime updatedOn;

//    @PrePersist
//    @PreUpdate
//    private void setup() {
//        prePersistOrUpdate();
//    }

    protected void prePersistOrUpdate() {
        // This method can be overridden by subclasses to add additional logic
    }
}
