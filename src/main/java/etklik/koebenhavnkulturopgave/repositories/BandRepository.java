package etklik.koebenhavnkulturopgave.repositories;

import etklik.koebenhavnkulturopgave.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandRepository extends JpaRepository<Band, Long> {
}
