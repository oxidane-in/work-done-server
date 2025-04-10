package in.oxidane.work.done.lineitem.dao;

import in.oxidane.work.done.lineitem.entity.LineItemMaterial;

import java.util.List;
import java.util.Optional;

public interface LineItemMaterialDao {
    LineItemMaterial save(LineItemMaterial lineItemMaterial);
    Optional<LineItemMaterial> findById(Long id);
    List<LineItemMaterial> findAll();
    void deleteById(Long id);
} 