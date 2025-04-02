package in.oxidane.work.done.project.dao;

import in.oxidane.work.done.project.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientDao {

    Client save(Client client);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    Optional<Client> findByHandle(String handle);

    boolean existsByName(String name);

    boolean existsByHandle(String handle);

    void deleteById(Long id);
} 