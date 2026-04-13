package co.edu.ustavillavicencio.quiz_arias_diaz.repositories;

import co.edu.ustavillavicencio.quiz_arias_diaz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
