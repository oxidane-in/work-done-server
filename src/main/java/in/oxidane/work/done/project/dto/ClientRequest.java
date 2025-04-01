package in.oxidane.work.done.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotBlank(message = "Client name is required")
    @Size(max = 100, message = "Client name must be less than 100 characters")
    @Schema(description = "Name of the client", example = "John Doe")
    private String clientName;

    @Size(max = 100, message = "Contact person name must be less than 100 characters")
    @Schema(description = "Name of the contact person", example = "Jane Smith")
    private String clientContactPerson;

    @Size(max = 15, message = "Contact number must be less than 15 characters")
    @Pattern(regexp = "^[0-9+\\-\\s]*$", message = "Invalid contact number format")
    @Schema(description = "Contact number of the client", example = "+1234567890")
    private String clientContactNumber;

    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must be less than 100 characters")
    @Schema(description = "Email of the client", example = "email@client.com")
    private String clientEmail;

    @Schema(description = "Address of the client", example = "123 Main St, City, Country")
    private String clientAddress;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    @Schema(description = "Description of the client", example = "A brief description about the client")
    private String clientDesc;
}
