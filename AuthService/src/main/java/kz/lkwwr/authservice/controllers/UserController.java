package kz.lkwwr.authservice.controllers;

import kz.lkwwr.authservice.dtos.UserDTO;
import kz.lkwwr.authservice.entities.User;
import kz.lkwwr.authservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable(name = "id") Long id) {
        User user = userService.getUser(id);
        return userService.convertToDTO(user);
    }

    @PostMapping("/save-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/delete-user")
    public void deleteUser(@RequestParam(name = "id") Long id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
    }
}
