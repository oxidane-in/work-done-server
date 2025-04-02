package in.oxidane.work.done.project.dao.impl;

import in.oxidane.work.done.project.dao.ClientDao;
import in.oxidane.work.done.project.entity.Client;
import in.oxidane.work.done.project.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClientDaoImpl implements ClientDao {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findByHandle(String handle) {
        return clientRepository.findByClientHandle(handle);
    }

    @Override
    public boolean existsByName(String name) {
        return clientRepository.existsByClientName(name);
    }

    @Override
    public boolean existsByHandle(String handle) {
        return clientRepository.existsByClientHandle(handle);
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
} 