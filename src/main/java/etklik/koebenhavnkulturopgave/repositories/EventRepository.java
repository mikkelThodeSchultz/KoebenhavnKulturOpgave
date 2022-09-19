package etklik.koebenhavnkulturopgave.repositories;

import etklik.koebenhavnkulturopgave.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
