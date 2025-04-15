package in.oxidane.work.done.shared.service;

import in.oxidane.work.done.shared.dto.OtherCostItemRequest;
import in.oxidane.work.done.shared.dto.OtherCostItemResponse;

import java.util.List;

public interface OtherCostItemService {

    OtherCostItemResponse createOtherCostItem(OtherCostItemRequest request);

    OtherCostItemResponse getOtherCostItemById(Long id);

    List<OtherCostItemResponse> getAllOtherCostItems();

    OtherCostItemResponse updateOtherItemCost(Long id, OtherCostItemRequest request);

    void deleteOtherCostItem(Long id);
}
