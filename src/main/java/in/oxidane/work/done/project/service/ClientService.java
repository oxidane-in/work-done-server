package in.oxidane.work.done.project.service;

import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;

import java.util.List;

public interface ClientService {

    ClientResponse createClient(ClientRequest request);

    List<ClientResponse> getAllClients();

    ClientResponse getClientById(Long id);

    ClientResponse getClientByHandle(String handle);

    ClientResponse updateClient(Long id, ClientRequest request);

    void deleteClient(Long id);
} 