package in.oxidane.work.done.lineitem.service.impl;

import in.oxidane.work.done.lineitem.dao.LineItemHeaderDao;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderRequest;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderResponse;
import in.oxidane.work.done.lineitem.entity.LineItemHeader;
import in.oxidane.work.done.lineitem.mapper.LineItemHeaderMapper;
import in.oxidane.work.done.lineitem.service.LineItemHeaderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemHeaderServiceImpl implements LineItemHeaderService {

    private final LineItemHeaderDao lineItemHeaderDao;
    private final LineItemHeaderMapper mapper;

    @Override
    @Transactional
    public LineItemHeaderResponse create(LineItemHeaderRequest request) {
        if (lineItemHeaderDao.existsByName(request.getLineItemHeaderName())) {
            throw new IllegalArgumentException("Line item header with this name already exists");
        }
        LineItemHeader entity = mapper.toEntity(request);
        return mapper.toResponse(lineItemHeaderDao.save(entity));
    }

    @Override
    @Transactional
    public LineItemHeaderResponse update(Long id, LineItemHeaderRequest request) {
        LineItemHeader existing = lineItemHeaderDao.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Line item header not found"));
        
        LineItemHeader updated = mapper.toUpdateEntityFromRequest(request, existing);
        return mapper.toResponse(lineItemHeaderDao.save(updated));
    }

    @Override
    @Transactional(readOnly = true)
    public LineItemHeaderResponse getById(Long id) {
        return lineItemHeaderDao.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Line item header not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public LineItemHeaderResponse getByHandle(String handle) {
        return lineItemHeaderDao.findByHandle(handle)
            .map(mapper::toResponse)
            .orElseThrow(() -> new EntityNotFoundException("Line item header not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<LineItemHeaderResponse> getAll() {
        return mapper.toResponse(lineItemHeaderDao.findAll());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!lineItemHeaderDao.findById(id).isPresent()) {
            throw new EntityNotFoundException("Line item header not found");
        }
        lineItemHeaderDao.deleteById(id);
    }
} 