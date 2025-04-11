package in.oxidane.work.done.lineitem.service.impl;

import in.oxidane.work.done.lineitem.dao.LineItemSubCategoryDao;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryResponse;
import in.oxidane.work.done.lineitem.entity.LineItemSubCategory;
import in.oxidane.work.done.lineitem.mapper.LineItemSubCategoryMapper;
import in.oxidane.work.done.lineitem.service.LineItemSubCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemSubCategoryServiceImpl implements LineItemSubCategoryService {

    private final LineItemSubCategoryDao dao;
    private final LineItemSubCategoryMapper mapper;

    @Override
    public LineItemSubCategoryResponse create(LineItemSubCategoryRequest request) {
        if (dao.existsByName(request.getLineItemSubCategoryName())) {
            throw new IllegalArgumentException("Sub category with this name already exists");
        }
        LineItemSubCategory entity = mapper.toEntity(request);
        return mapper.toResponse(dao.save(entity));
    }

    @Override
    public LineItemSubCategoryResponse update(Long id, LineItemSubCategoryRequest request) {
        LineItemSubCategory existing = dao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Sub category not found"));

        LineItemSubCategory updated = mapper.toUpdateEntityFromRequest(request, existing);
        return mapper.toResponse(dao.save(updated));
    }

    @Override
    public LineItemSubCategoryResponse getById(Long id) {
        return dao.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Sub category not found"));
    }

    @Override
    public LineItemSubCategoryResponse getByHandle(String handle) {
        return dao.findByHandle(handle)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Sub category not found"));
    }

    @Override
    public List<LineItemSubCategoryResponse> getAll() {
        return mapper.toResponse(dao.findAll());
    }

    @Override
    public void deleteById(Long id) {
        if (!dao.findById(id).isPresent()) {
            throw new EntityNotFoundException("Sub category not found");
        }
        dao.deleteById(id);
    }
}
