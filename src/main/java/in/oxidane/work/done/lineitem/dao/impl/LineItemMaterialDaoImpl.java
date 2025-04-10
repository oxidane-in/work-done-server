package in.oxidane.work.done.lineitem.dao.impl;

import in.oxidane.work.done.lineitem.dao.LineItemMaterialDao;
import in.oxidane.work.done.lineitem.entity.LineItemMaterial;
import in.oxidane.work.done.lineitem.repository.LineItemMaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LineItemMaterialDaoImpl implements LineItemMaterialDao {

    private final LineItemMaterialRepository repository;

    @Override
    public LineItemMaterial save(LineItemMaterial lineItemMaterial) {
        return repository.save(lineItemMaterial);
    }

    @Override
    public Optional<LineItemMaterial> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<LineItemMaterial> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
} 