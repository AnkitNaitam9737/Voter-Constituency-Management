package org.constituencyservice.utils;

import feign.Headers;
import jdk.jfr.ContentType;
import org.constituencyservice.dto.VoterDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "VOTER-SERVICE", url = "http://localhost:8081/api/voter")
public interface VoterFeign {

    @PostMapping("/add")
    ResponseEntity<VoterDetailsDto> addVoter(@RequestBody VoterDetailsDto voterDetailsDto);

    @GetMapping("/getAllVoters")
    ResponseEntity<List<VoterDetailsDto>> getAllVoters();
}
