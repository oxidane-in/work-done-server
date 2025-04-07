package in.oxidane.work.done.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import in.oxidane.work.done.common.constant.Endpoints;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Client Management", description = "APIs for client management operations")
@Validated
@RequestMapping(Endpoints.CLIENT_V1)
public interface ClientController {

    @Operation(summary = "Create a new client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Client created successfully",
                     content = @Content(schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data",
                     content = @Content),
        @ApiResponse(responseCode = "409", description = "Client already exists",
                     content = @Content)
    })
    @PostMapping
    ResponseEntity<ClientResponse> createClient(
            @Parameter(description = "Client details", required = true)
            @RequestBody ClientRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retrieved all clients")
    })
    @GetMapping
    ResponseEntity<List<ClientResponse>> getAllClients();

    @Operation(summary = "Get a client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client found"),
        @ApiResponse(responseCode = "404", description = "Client not found",
                     content = @Content)
    })
    @GetMapping("/{id}")
    ResponseEntity<ClientResponse> getClientById(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id);

    @Operation(summary = "Get a client by handle")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client found"),
        @ApiResponse(responseCode = "404", description = "Client not found",
                     content = @Content)
    })
    @GetMapping("/handle/{handle}")
    ResponseEntity<ClientResponse> getClientByHandle(
            @Parameter(description = "Client handle", required = true)
            @PathVariable String handle);

    @Operation(summary = "Update a client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data",
                     content = @Content),
        @ApiResponse(responseCode = "404", description = "Client not found",
                     content = @Content)
    })
    @PutMapping("/{id}")
    ResponseEntity<ClientResponse> updateClient(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id,
            @Parameter(description = "Updated client details", required = true)
            @RequestBody ClientRequest request) throws JsonProcessingException, SchemaValidationException;

    @Operation(summary = "Delete a client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Client not found",
                     content = @Content)
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(
            @Parameter(description = "Client ID", required = true)
            @PathVariable Long id);
}
