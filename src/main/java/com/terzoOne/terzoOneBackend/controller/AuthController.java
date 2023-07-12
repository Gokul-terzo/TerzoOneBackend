package com.terzoOne.terzoOneBackend.controller;

import com.terzoOne.terzoOneBackend.auth.AuthenticationRequest;
import com.terzoOne.terzoOneBackend.auth.AuthenticationService;
import com.terzoOne.terzoOneBackend.auth.RegisterRequest;
import com.terzoOne.terzoOneBackend.auth.AuthenticationResponse;
import com.terzoOne.terzoOneBackend.dto.UserRole;
import com.terzoOne.terzoOneBackend.models.Role;
import com.terzoOne.terzoOneBackend.models.User;
import com.terzoOne.terzoOneBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;

    private final AuthenticationService service;

    private User user;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/role/{email}")
    public UserRole getRole(@PathVariable String email){
        User user=userRepository.findByEmail(email).orElseThrow();
        UserRole userRole=new UserRole();
        userRole.setRole(user.getRole().name());
        return userRole;
    }
}
