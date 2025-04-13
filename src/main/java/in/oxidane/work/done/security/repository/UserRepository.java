package in.oxidane.work.done.security.repository;

import in.oxidane.work.done.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
