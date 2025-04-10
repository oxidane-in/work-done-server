package in.oxidane.work.done.lineitem.repository;

import in.oxidane.work.done.lineitem.entity.LineItemMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemMaterialRepository extends JpaRepository<LineItemMaterial, Long> {
} 