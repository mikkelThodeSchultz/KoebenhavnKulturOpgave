package etklik.koebenhavnkulturopgave.controllers;

import etklik.koebenhavnkulturopgave.model.Event;
import etklik.koebenhavnkulturopgave.model.Review;
import etklik.koebenhavnkulturopgave.model.User;
import etklik.koebenhavnkulturopgave.services.IEventService;
import etklik.koebenhavnkulturopgave.services.IReviewService;
import etklik.koebenhavnkulturopgave.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class ReviewController {

    private IReviewService reviewService;
    private IEventService eventService;

    private IUserService userService;

    public ReviewController(IReviewService reviewService, IEventService eventService, IUserService userService){
        this.reviewService = reviewService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> createReview(@RequestBody Review review, @RequestParam Long eventID, @RequestParam Long userID){
        Optional<Event> event_ = eventService.findById(eventID);
        Optional<User> user_ = userService.findById(userID);
        if(event_.isPresent() && user_.isPresent()){
            review.setEvent(event_.get());
            review.setUser(user_.get());
            reviewService.save(review);
            return new ResponseEntity<>("ok, event oprettet", HttpStatus.OK);
        }
        return new ResponseEntity<>("Fejl, band ikke oprettet " + eventID, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getReviewsForEvent")
    public ResponseEntity<Set<Review>> getReview (@RequestBody Event event){
        Optional<Event> event_ = eventService.findById(event.getId());
        if(event_.isPresent()) {
            return new ResponseEntity<>(event.getReviews(), HttpStatus.OK);
        } return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
