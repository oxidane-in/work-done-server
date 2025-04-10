package in.oxidane.work.done.lineitem.service;

import in.oxidane.work.done.lineitem.dto.LineItemMaterialRequest;
import in.oxidane.work.done.lineitem.dto.LineItemMaterialResponse;

import java.util.List;

public interface LineItemMaterialService {
    LineItemMaterialResponse create(LineItemMaterialRequest request);
    LineItemMaterialResponse getById(Long id);
    List<LineItemMaterialResponse> getAll();
    LineItemMaterialResponse update(Long id, LineItemMaterialRequest request);
    void delete(Long id);
} 