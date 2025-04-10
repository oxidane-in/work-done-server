package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dao.LineItemCategoryDao;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryResponse;
import in.oxidane.work.done.lineitem.entity.LineItemCategory;
import in.oxidane.work.done.lineitem.mapper.LineItemCategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemCategoryServiceImpl implements LineItemCategoryService {

    private final LineItemCategoryDao lineItemCategoryDao;
    private final LineItemCategoryMapper mapper;

    @Override
    @Transactional
    public LineItemCategoryResponse create(LineItemCategoryRequest request) {
        if (lineItemCategoryDao.existsByName(request.getLineItemCategoryName())) {
            throw new IllegalArgumentException("Category with this name already exists");
        }
        LineItemCategory category = mapper.toEntity(request);
        return mapper.toResponse(lineItemCategoryDao.save(category));
    }

    @Override
    @Transactional
    public LineItemCategoryResponse update(Long id, LineItemCategoryRequest request) {
        LineItemCategory category = lineItemCategoryDao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        
        LineItemCategory updatedCategory = mapper.toUpdateEntityFromRequest(request, category);
        return mapper.toResponse(lineItemCategoryDao.save(updatedCategory));
    }

    @Override
    @Transactional(readOnly = true)
    public LineItemCategoryResponse getById(Long id) {
        return lineItemCategoryDao.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public LineItemCategoryResponse getByHandle(String handle) {
        return lineItemCategoryDao.findByHandle(handle)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LineItemCategoryResponse> getAll() {
        return mapper.toResponse(lineItemCategoryDao.findAll());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!lineItemCategoryDao.findById(id).isPresent()) {
            throw new EntityNotFoundException("Category not found");
        }
        lineItemCategoryDao.deleteById(id);
    }
} 