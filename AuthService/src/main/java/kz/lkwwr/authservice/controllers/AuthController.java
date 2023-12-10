package kz.lkwwr.authservice.controllers;

import kz.lkwwr.authservice.dtos.LoginRequest;
import kz.lkwwr.authservice.dtos.LoginResponse;
import kz.lkwwr.authservice.dtos.RegisterRequest;
import kz.lkwwr.authservice.services.impl.UserServiceImpl;
import kz.lkwwr.authservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImpl userServiceImpl;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<LoginResponse> createAuthToken(@RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userServiceImpl.loadUserByUsername(request.getUsername());
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        if (userServiceImpl.findByUsername(request.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userServiceImpl.createNewUser(request);
        return new ResponseEntity<>(HttpStatus.OK);
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
//    @PostMapping("/update-user")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}
