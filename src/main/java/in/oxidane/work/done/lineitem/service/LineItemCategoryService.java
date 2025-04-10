package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dto.LineItemCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemCategoryResponse;

import java.util.List;

public interface LineItemCategoryService {
    LineItemCategoryResponse create(LineItemCategoryRequest request);
    LineItemCategoryResponse update(Long id, LineItemCategoryRequest request);
    LineItemCategoryResponse getById(Long id);
    LineItemCategoryResponse getByHandle(String handle);
    List<LineItemCategoryResponse> getAll();
    void delete(Long id);
} 