package in.oxidane.work.done.project.controller.impl;

import in.oxidane.work.done.project.controller.ClientController;
import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;
import in.oxidane.work.done.project.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest request) {
        ClientResponse createdClient = clientService.createClient(request);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        ClientResponse client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientByHandle(@PathVariable String handle) {
        ClientResponse client = clientService.getClientByHandle(handle);
        return ResponseEntity.ok(client);
    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(@PathVariable Long id, @RequestBody ClientRequest request) {
        ClientResponse updatedClient = clientService.updateClient(id, request);
        return ResponseEntity.ok(updatedClient);
    }

    @Override
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
