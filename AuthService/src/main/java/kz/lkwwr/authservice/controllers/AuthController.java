package kz.lkwwr.authservice.controllers;

import kz.lkwwr.authservice.dtos.JwtRequest;
import kz.lkwwr.authservice.dtos.JwtResponse;
import kz.lkwwr.authservice.services.UserService;
import kz.lkwwr.authservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @PostMapping("/authh")
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody JwtRequest request) {
        UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> users = userService.getUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
//        User user = userService.getUser(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
//        User user = userService.getUser(id);
//        userService.deleteUser(user);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> register(@RequestBody User user) {
//        userService.addUser(user);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/update-user")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}
