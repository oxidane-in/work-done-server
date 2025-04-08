package in.oxidane.work.done.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderRequest {
    
    @NotBlank(message = "Work order code is required")
    @Size(max = 50, message = "Work order code must not exceed 50 characters")
    private String workOrderCode;
    
    @NotNull(message = "Project ID is required")
    private Long projectId;
    
    @NotNull(message = "Work order date is required")
    private LocalDate workOrderDate;
    
    @Size(max = 500, message = "Work order description must not exceed 500 characters")
    private String workOrderDesc;
} 