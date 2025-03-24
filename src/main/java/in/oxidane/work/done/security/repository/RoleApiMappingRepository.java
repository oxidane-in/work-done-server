package in.oxidane.work.done.security.repository;

import in.oxidane.work.done.security.model.Role;
import in.oxidane.work.done.security.model.RoleApiMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleApiMappingRepository extends JpaRepository<RoleApiMapping, Long> {

    @Query("SELECT r FROM RoleApiMapping r WHERE r.role.name IN :roleNames " +
        "AND :requestUri LIKE r.apiPattern AND r.httpMethod = :method")
    Optional<RoleApiMapping> findByRoleNamesAndApiPattern(@Param("roleNames") List<String> roleNames,
                                                          @Param("requestUri") String requestUri,
                                                          @Param("method") String method);

    List<RoleApiMapping> findByRole(Role role);
}
