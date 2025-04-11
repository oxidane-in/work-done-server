package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dto.LineItemWorkerRequest;
import in.oxidane.work.done.lineitem.dto.LineItemWorkerResponse;

import java.util.List;

public interface LineItemWorkerService {
    LineItemWorkerResponse create(LineItemWorkerRequest request);
    LineItemWorkerResponse getById(Long id);
    List<LineItemWorkerResponse> getAll();
    LineItemWorkerResponse update(Long id, LineItemWorkerRequest request);
    void delete(Long id);
} 