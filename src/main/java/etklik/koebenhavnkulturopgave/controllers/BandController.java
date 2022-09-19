package etklik.koebenhavnkulturopgave.controllers;

import etklik.koebenhavnkulturopgave.model.Band;
import etklik.koebenhavnkulturopgave.model.User;
import etklik.koebenhavnkulturopgave.repositories.BandRepository;
import etklik.koebenhavnkulturopgave.services.IBandService;
import etklik.koebenhavnkulturopgave.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BandController {

    private IBandService bandService;

    public BandController(IBandService bandService){
        this.bandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        if(bandService.save(band)!=null) {
            return new ResponseEntity<>("bruger " + band.getName(), HttpStatus.OK);
        } return new ResponseEntity<>("Fejl i oprettelsen", HttpStatus.BAD_REQUEST);
    }
}