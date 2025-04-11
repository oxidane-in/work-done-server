package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dto.LineItemHeaderRequest;
import in.oxidane.work.done.lineitem.dto.LineItemHeaderResponse;

import java.util.List;

public interface LineItemHeaderService {
    LineItemHeaderResponse create(LineItemHeaderRequest request);
    LineItemHeaderResponse update(Long id, LineItemHeaderRequest request);
    LineItemHeaderResponse getById(Long id);
    LineItemHeaderResponse getByHandle(String handle);
    List<LineItemHeaderResponse> getAll();
    void delete(Long id);
} 