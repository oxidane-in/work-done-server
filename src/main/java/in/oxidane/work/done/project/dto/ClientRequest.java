package in.oxidane.work.done.project.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @Schema(description = "Name of the client", example = "John Doe")
    private String clientName;

    @Schema(description = "Name of the contact person", example = "Jane Smith")
    private String clientContactPerson;

    @Schema(description = "Contact number of the client", example = "+1234567890")
    private String clientContactNumber;

    @Schema(description = "Email of the client", example = "email@client.com")
    private String clientEmail;

    @Schema(description = "Address of the client", example = "123 Main St, City, Country")
    private String clientAddress;

    @Schema(description = "Description of the client", example = "A brief description about the client")
    private String clientDesc;
}
