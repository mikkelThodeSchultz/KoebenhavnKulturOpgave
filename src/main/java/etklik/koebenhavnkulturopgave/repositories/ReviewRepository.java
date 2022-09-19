package etklik.koebenhavnkulturopgave.repositories;

import etklik.koebenhavnkulturopgave.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
