package etklik.koebenhavnkulturopgave.services;

import etklik.koebenhavnkulturopgave.model.Band;
import etklik.koebenhavnkulturopgave.model.Event;
import etklik.koebenhavnkulturopgave.repositories.BandRepository;
import etklik.koebenhavnkulturopgave.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService{

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> set = new HashSet<>();
        set.addAll(eventRepository.findAll()); // dobbelt :: betyder at du giver metoden med som parameter
        return set;
    }

    @Override
    public Event save(Event object) {
        return eventRepository.save(object);
    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepository.findById(aLong);
    }
}
