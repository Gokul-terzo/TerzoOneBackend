package com.terzoOne.terzoOneBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        String email = loginRequest.getEmail();
//        String password = loginRequest.getPassword();
//
//        // Validate the login request
//        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
//            return ResponseEntity.badRequest().body("Email and password are required.");
//        }
//
//        // Authenticate the user
//        boolean isAuthenticated = userService.authenticateUser(email, password);
//        if (!isAuthenticated) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
//        }
//
//        // Generate and return a JWT token or perform any other authentication-related actions
//        String token = userService.generateJwtToken(email);
//
//        // Return the token in the response body
//        return ResponseEntity.ok(token);
//    }
}
