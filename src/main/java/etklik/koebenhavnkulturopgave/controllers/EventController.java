package etklik.koebenhavnkulturopgave.controllers;

import etklik.koebenhavnkulturopgave.model.Band;
import etklik.koebenhavnkulturopgave.model.Event;
import etklik.koebenhavnkulturopgave.model.User;
import etklik.koebenhavnkulturopgave.services.IBandService;
import etklik.koebenhavnkulturopgave.services.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {

    private IEventService eventService;
    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService){
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID){
        Optional<Band> band_ = bandService.findById(bandID);
        if(band_.isPresent()){
            event.setBand(band_.get());
            eventService.save(event);
            return new ResponseEntity<>("ok, event oprettet", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fejl, band ikke oprettet " + bandID, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getEvents")
    public ResponseEntity<Set<Event>> getEvents(){
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }
}
