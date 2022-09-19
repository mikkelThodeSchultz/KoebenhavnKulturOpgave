package etklik.koebenhavnkulturopgave.controllers;
import etklik.koebenhavnkulturopgave.model.User;
import etklik.koebenhavnkulturopgave.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        System.out.println("Test");
        if(userService.save(user)!=null) {
            return new ResponseEntity<>("bruger " + user.getName(), HttpStatus.OK);
        } return new ResponseEntity<>("Fejl i oprettelsen", HttpStatus.OK);
    }
}
