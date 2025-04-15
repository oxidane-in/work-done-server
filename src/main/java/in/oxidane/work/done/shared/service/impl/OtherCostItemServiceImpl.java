package in.oxidane.work.done.shared.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.shared.dao.impl.OtherCostItemDaoImpl;
import in.oxidane.work.done.shared.dto.OtherCostItemRequest;
import in.oxidane.work.done.shared.dto.OtherCostItemResponse;
import in.oxidane.work.done.shared.entity.OtherCostItem;
import in.oxidane.work.done.shared.mapper.OtherCostItemMapper;
import in.oxidane.work.done.shared.service.OtherCostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OtherCostItemServiceImpl implements OtherCostItemService {

    private final OtherCostItemDaoImpl otherCostItemDao;
    private final OtherCostItemMapper otherCostItemMapper;

    @Override
    public OtherCostItemResponse createOtherCostItem(OtherCostItemRequest request) {
        OtherCostItem otherCostItem = otherCostItemMapper.toEntity(request);
        OtherCostItem savedOtherCostItem = otherCostItemDao.save(otherCostItem);
        return otherCostItemMapper.toResponse(savedOtherCostItem);
    }

    @Override
    public OtherCostItemResponse getOtherCostItemById(Long id) {
        OtherCostItem otherCostItem = otherCostItemDao.findById(id).
            orElseThrow(() -> new ResourceNotFoundException("OtherCostItem not found with id" + id));
        return otherCostItemMapper.toResponse(otherCostItem);
    }

    @Override
    public List<OtherCostItemResponse> getAllOtherCostItems() {
        List<OtherCostItem> allOtherCostItems = otherCostItemDao.findAll();
        return otherCostItemMapper.toResponse(allOtherCostItems);
    }

    @Override
    public OtherCostItemResponse updateOtherItemCost(Long id, OtherCostItemRequest request) {
        OtherCostItem existingOtherCostItem = otherCostItemDao.findById(id).
            orElseThrow(()-> new ResourceNotFoundException("OtherCostItem not found with id" + id));

        OtherCostItem updatedOtherCostItem = otherCostItemMapper.toUpdateEntityFromRequest(request, existingOtherCostItem);
        return otherCostItemMapper.toResponse(updatedOtherCostItem);
    }

    @Override
    public void deleteOtherCostItem(Long id) {
        if(!otherCostItemDao.existById(id)){
            throw new ResourceNotFoundException("OtherCostItem not found with ID: " + id);
        }

        otherCostItemDao.delete(id);
    }

}
