package org.authenticationservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.authenticationservice.dto.VoterCredentials;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "VOTER-SERVICE", url = "http://localhost:8081/api/voter/")
public interface VoterFeignClient {

    @PostMapping("/")
    ResponseEntity<VoterCredentials> addVoter(@RequestBody VoterCredentials voterCredentials);

    @GetMapping("/byEmail")
    ResponseEntity<VoterCredentials> findByEmail(@RequestParam String email);
}
