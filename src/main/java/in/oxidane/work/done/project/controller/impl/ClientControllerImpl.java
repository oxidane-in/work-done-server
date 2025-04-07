package in.oxidane.work.done.project.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.oxidane.work.done.common.constant.SchemaPaths;
import in.oxidane.work.done.common.exception.SchemaValidationException;
import in.oxidane.work.done.common.validation.SchemaValidator;
import in.oxidane.work.done.project.controller.ClientController;
import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;
import in.oxidane.work.done.project.service.ClientService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final SchemaValidator schemaValidator;
    private String createClientRequestSchema;
    private String updateClientRequestSchema;

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.CREATE_CLIENT_REQUEST_SCHEMA).getInputStream()) {
            createClientRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
        try (InputStream inputStream = resourceLoader.getResource(
            SchemaPaths.UPDATE_CLIENT_REQUEST_SCHEMA).getInputStream()) {
            updateClientRequestSchema = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }
    }

    @Override
    public ResponseEntity<ClientResponse> createClient(ClientRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(createClientRequestSchema,objectMapper.writeValueAsString(request));
        ClientResponse createdClient = clientService.createClient(request);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientById(Long id) {
        ClientResponse client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientByHandle(String handle) {
        ClientResponse client = clientService.getClientByHandle(handle);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(Long id, ClientRequest request) throws JsonProcessingException, SchemaValidationException {
        schemaValidator.validate(updateClientRequestSchema,objectMapper.writeValueAsString(request));
        ClientResponse updatedClient = clientService.updateClient(id, request);
        return ResponseEntity.ok(updatedClient);
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
