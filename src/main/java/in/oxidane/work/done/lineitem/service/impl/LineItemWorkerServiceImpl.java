package in.oxidane.work.done.lineitem.service.impl;

import in.oxidane.work.done.lineitem.dao.LineItemWorkerDao;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerRequest;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerResponse;
import in.oxidane.work.done.lineitem.entity.LineItemWorker;
import in.oxidane.work.done.lineitem.mapper.LineItemWorkerMapper;
import in.oxidane.work.done.lineitem.service.LineItemWorkerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineItemWorkerServiceImpl implements LineItemWorkerService {

    private final LineItemWorkerDao lineItemWorkerDao;
    private final LineItemWorkerMapper mapper;

    @Override
    public LineItemWorkerResponse create(LineItemWorkerRequest request) {
        LineItemWorker entity = mapper.toEntity(request);
        LineItemWorker saved = lineItemWorkerDao.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public LineItemWorkerResponse getById(Long id) {
        return lineItemWorkerDao.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("LineItemWorker not found with id: " + id));
    }

    @Override
    public List<LineItemWorkerResponse> getAll() {
        return mapper.toResponse(lineItemWorkerDao.findAll());
    }

    @Override
    public LineItemWorkerResponse update(Long id, LineItemWorkerRequest request) {
        LineItemWorker existing = lineItemWorkerDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LineItemWorker not found with id: " + id));

        LineItemWorker updated = mapper.toUpdateEntityFromRequest(request);
        return mapper.toResponse(lineItemWorkerDao.save(updated));
    }

    @Override
    public void delete(Long id) {
        if (!lineItemWorkerDao.existsById(id)) {
            throw new EntityNotFoundException("LineItemWorker not found with id: " + id);
        }
        lineItemWorkerDao.deleteById(id);
    }
}
