package in.oxidane.work.done.security.repository;

import in.oxidane.work.done.security.model.UserApiMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserApiMappingRepository extends JpaRepository<UserApiMapping, Long> {

    @Query("SELECT u FROM UserApiMapping u WHERE u.user.id = :userId " +
        "AND :requestUri LIKE u.apiPattern AND u.httpMethod = :method")
    Optional<UserApiMapping> findByUserIdAndApiPattern(@Param("userId") Long userId,
                                                       @Param("requestUri") String requestUri,
                                                       @Param("method") String method);
}
