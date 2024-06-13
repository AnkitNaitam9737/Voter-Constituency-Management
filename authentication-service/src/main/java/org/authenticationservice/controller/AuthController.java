package org.authenticationservice.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private VoterFeignClient client;

    @PostMapping("/register/")
    public ResponseEntity<VoterCredentials> registerVoter(@RequestBody VoterCredentials credentials) {
        return this.client.addVoter(credentials);
    }

    @PostMapping("/token/")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) {
        log.info("Generating token");
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()) {
            log.info("Authenticated");
            return new ResponseEntity<>(this.jwtService.generateToken(authRequest.getUsername()),HttpStatus.OK);
        }else {
            log.info("Not authenticated");
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/validate/")
    public ResponseEntity<Void> validateToken(@RequestParam String token) {
        this.jwtService.validateToken(token);
        return ResponseEntity.ok().build();
    }

    //created just to check feign client is working or not
    @GetMapping("/byEmail/")
    public ResponseEntity<VoterCredentials> getVoterByEmail(@RequestParam String email){
        return this.client.findByEmail(email);
    }
}
