package in.oxidane.work.done.lineitem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemHeaderResponse {
    private Long lineItemHeaderId;
    private String lineItemHeaderName;
    private String lineItemHeaderHandle;
    private String lineItemHeaderDesc;
} 