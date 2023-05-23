package learning.controller;

import learning.model.User;
import learning.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Iterable<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PutMapping
    public User saveUser(@Validated @RequestBody User user) {
        return service.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
    }
}
