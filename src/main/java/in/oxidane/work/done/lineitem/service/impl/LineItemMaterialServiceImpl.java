package in.oxidane.work.done.lineitem.service.impl;

import in.oxidane.work.done.lineitem.dao.LineItemMaterialDao;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialRequest;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialResponse;
import in.oxidane.work.done.lineitem.entity.LineItemMaterial;
import in.oxidane.work.done.lineitem.mapper.LineItemMaterialMapper;
import in.oxidane.work.done.lineitem.service.LineItemMaterialService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemMaterialServiceImpl implements LineItemMaterialService {

    private final LineItemMaterialDao lineItemMaterialDao;
    private final LineItemMaterialMapper mapper;

    @Override
    @Transactional
    public LineItemMaterialResponse create(LineItemMaterialRequest request) {
        LineItemMaterial entity = mapper.toEntity(request);
        LineItemMaterial savedEntity = lineItemMaterialDao.save(entity);
        return mapper.toResponse(savedEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public LineItemMaterialResponse getById(Long id) {
        return lineItemMaterialDao.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("LineItemMaterial not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LineItemMaterialResponse> getAll() {
        return mapper.toResponse(lineItemMaterialDao.findAll());
    }

    @Override
    @Transactional
    public LineItemMaterialResponse update(Long id, LineItemMaterialRequest request) {
        LineItemMaterial existingEntity = lineItemMaterialDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LineItemMaterial not found with id: " + id));

        LineItemMaterial updatedEntity = mapper.toUpdateEntityFromRequest(request);
        return mapper.toResponse(lineItemMaterialDao.save(updatedEntity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!lineItemMaterialDao.findById(id).isPresent()) {
            throw new EntityNotFoundException("LineItemMaterial not found with id: " + id);
        }
        lineItemMaterialDao.deleteById(id);
    }
}
