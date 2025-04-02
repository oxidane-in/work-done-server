package in.oxidane.work.done.project.service.impl;

import in.oxidane.work.done.common.exception.ResourceNotFoundException;
import in.oxidane.work.done.project.dao.ClientDao;
import in.oxidane.work.done.project.dto.ClientRequest;
import in.oxidane.work.done.project.dto.ClientResponse;
import in.oxidane.work.done.project.entity.Client;
import in.oxidane.work.done.project.mapper.ClientMapper;
import in.oxidane.work.done.project.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse createClient(ClientRequest request) {
        Client client = clientMapper.toEntity(request);
        Client savedClient = clientDao.save(client);
        return clientMapper.toResponse(savedClient);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientDao.findAll();
        return clientMapper.toResponse(clients);
    }

    @Override
    public ClientResponse getClientById(Long id) {
        Client client = clientDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse getClientByHandle(String handle) {
        Client client = clientDao.findByHandle(handle)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with handle: " + handle));
        return clientMapper.toResponse(client);
    }

    @Override
    public ClientResponse updateClient(Long id, ClientRequest request) {
        Client existingClient = clientDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));

        Client updatedClient = clientMapper.toUpdateEntityFromRequest(request, existingClient);
        Client savedClient = clientDao.save(updatedClient);
        return clientMapper.toResponse(savedClient);
    }

    @Override
    public void deleteClient(Long id) {
        if (clientDao.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
        clientDao.deleteById(id);
    }
}
