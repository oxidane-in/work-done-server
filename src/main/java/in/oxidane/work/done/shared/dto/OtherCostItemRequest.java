package in.oxidane.work.done.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtherCostItemRequest {
    private String otherCostItemName;
    private String otherCostItemDesc;
}
