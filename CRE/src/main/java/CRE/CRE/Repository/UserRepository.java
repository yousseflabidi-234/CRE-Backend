package CRE.CRE.Repository;

import CRE.CRE.Entity.UserCRE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserCRE, Long> {
    Optional<UserCRE> findByUsername(String username);
}
