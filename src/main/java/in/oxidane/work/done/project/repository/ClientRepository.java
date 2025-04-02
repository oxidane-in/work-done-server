package in.oxidane.work.done.project.repository;

import in.oxidane.work.done.project.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Optional<Client> findByClientHandle(String clientHandle);
    
    boolean existsByClientName(String clientName);
    
    boolean existsByClientHandle(String clientHandle);
} 