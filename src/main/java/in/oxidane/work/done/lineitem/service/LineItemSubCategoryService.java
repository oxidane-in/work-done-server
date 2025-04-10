package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryRequest;
import in.oxidane.work.done.lineitem.dto.LineItemSubCategoryResponse;

import java.util.List;

public interface LineItemSubCategoryService {
    LineItemSubCategoryResponse create(LineItemSubCategoryRequest request);
    LineItemSubCategoryResponse update(Long id, LineItemSubCategoryRequest request);
    LineItemSubCategoryResponse getById(Long id);
    LineItemSubCategoryResponse getByHandle(String handle);
    List<LineItemSubCategoryResponse> getAll();
    void deleteById(Long id);
} 