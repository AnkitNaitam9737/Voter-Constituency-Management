package org.authenticationservice.controller;

import org.authenticationservice.dto.AuthRequest;
import org.authenticationservice.dto.VoterCredentials;
import org.authenticationservice.service.JwtService;
import org.authenticationservice.utils.VoterFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private VoterFeignClient client;

    @PostMapping("/register")
    public ResponseEntity<VoterCredentials> registerVoter(@RequestBody VoterCredentials credentials) {
        return this.client.addVoter(credentials);
    }

    @GetMapping("/token")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            return new ResponseEntity<>(this.jwtService.generateToken(authRequest.getUsername()),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }


    }

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestParam String token) {
        this.jwtService.validateToken(token);
        return ResponseEntity.ok().build();
    }
}
