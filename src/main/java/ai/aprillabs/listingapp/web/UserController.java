package ai.aprillabs.listingapp.web;

import ai.aprillabs.listingapp.domain.User;
import ai.aprillabs.listingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private final ai.aprillabs.listingapp.service.UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(
                user,
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Integer getDiscountRate(@Valid @PathVariable Integer id) {
        return userService.getDiscountRateForUser(id);
    }
}
