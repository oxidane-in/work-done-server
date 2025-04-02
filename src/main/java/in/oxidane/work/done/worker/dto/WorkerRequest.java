package in.oxidane.work.done.worker.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerRequest {

    @NotBlank(message = "Worker name is required")
    @Size(max = 255, message = "Worker name must be less than 255 characters")
    private String workerName;

    @NotNull(message = "Worker type ID is required")
    private Long workerTypeId;

    @NotNull(message = "Worker rate is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Worker rate must be greater than 0")
    private BigDecimal workerRate;

    @NotBlank(message = "Bank account number is required")
    @Size(max = 20, message = "Bank account number must be less than 20 characters")
    private String workerBankAccount;

    @NotBlank(message = "IFSC code is required")
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC code format")
    private String workerIFSC;

    @NotNull(message = "Birth date is required")
    private LocalDate workerBirthDate;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Mobile number must contain 10-15 digits")
    private String workerMobileNumber;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State must be less than 100 characters")
    private String workerState;

    @NotNull(message = "Date of joining is required")
    private LocalDate workerDOJ;
}
