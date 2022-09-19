package etklik.koebenhavnkulturopgave.repositories;

import etklik.koebenhavnkulturopgave.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
