package in.oxidane.work.done.lineitem.repository;

import in.oxidane.work.done.lineitem.entity.LineItemHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LineItemHeaderRepository extends JpaRepository<LineItemHeader, Long> {
    Optional<LineItemHeader> findByLineItemHeaderHandle(String handle);
    boolean existsByLineItemHeaderName(String name);
} 