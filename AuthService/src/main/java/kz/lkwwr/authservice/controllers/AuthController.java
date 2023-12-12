package kz.lkwwr.authservice.controllers;

import kz.lkwwr.authservice.dtos.LoginRequest;
import kz.lkwwr.authservice.dtos.LoginResponse;
import kz.lkwwr.authservice.dtos.RegisterRequest;
import kz.lkwwr.authservice.dtos.UserDto;
import kz.lkwwr.authservice.entities.User;
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

import java.util.List;

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

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userServiceImpl.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/admin/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") Long id) {
        User user = userServiceImpl.getUser(id);
        UserDto userDto = user.toDto();
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping("/admin/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        User user = userServiceImpl.getUser(id);
        userServiceImpl.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/update-user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userDto.toEntity();
        userServiceImpl.saveUser(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
