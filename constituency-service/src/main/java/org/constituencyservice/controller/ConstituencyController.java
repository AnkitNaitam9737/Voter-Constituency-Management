package org.constituencyservice.controller;

import org.constituencyservice.dto.ConstituencyDto;
import org.constituencyservice.dto.VoterDetailsDto;
import org.constituencyservice.service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/constituency/")
public class ConstituencyController {

    @Autowired
    private ConstituencyService service;

    @GetMapping("/votersCount/{constituencyId}")
    public ResponseEntity<Long> votersCountByConstituency(@PathVariable("constituencyId") Integer constituencyId) {
        return new ResponseEntity<>(this.service.totalVotersByConstituency(constituencyId), HttpStatus.OK);
    }

    @GetMapping("/getAllVoters/{constituencyId}")
    public ResponseEntity<List<VoterDetailsDto>> getVoterDetailsByConstituency(@PathVariable("constituencyId") Integer constituencyId) {
        return new ResponseEntity<>(this.service.getVotersByConstituency(constituencyId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ConstituencyDto> addConstituency(@RequestBody ConstituencyDto constituencyDto) {
        return new ResponseEntity<>(this.service.addConstituency(constituencyDto), HttpStatus.CREATED);
    }

}
