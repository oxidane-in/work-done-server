package in.oxidane.work.done.lineitem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemCategoryResponse {
    private Long lineItemCategoryId;
    private String lineItemCategoryName;
    private String lineItemCategoryHandle;
    private String lineItemCategoryDesc;
} 