package org.voterservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.voterservice.dtos.VoterDto;
import org.voterservice.service.VoterService;

import java.util.List;

@RestController
@RequestMapping("/api/voter/")
public class VoterController {

    @Autowired
    private VoterService voterService;

    @PostMapping()
    public ResponseEntity<VoterDto> addVoter(@RequestBody VoterDto voterDto) {
        return new ResponseEntity<>(this.voterService.addVoter(voterDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAllVoters")
    public ResponseEntity<List<VoterDto>> getAllVoters() {
        return new ResponseEntity<>(this.voterService.getAllVoters(), HttpStatus.OK);
    }

    @GetMapping("/getVoter/{id}")
    public ResponseEntity<VoterDto> getVoterById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.voterService.getVoterById(id),HttpStatus.FOUND);
    }

    @GetMapping("/totalVotersCount")
    public ResponseEntity<Long> getTotalVotersCount(){
        return new ResponseEntity<>(this.voterService.totalNoOfVoters(), HttpStatus.OK);
    }

    @GetMapping("/countByGender")
    public ResponseEntity<Long> getTotalVotersCountByGender(@RequestParam String gender){
        return new ResponseEntity<>(this.voterService.totalVotersByGender(gender), HttpStatus.OK);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<VoterDto> getVoterByEmail(@RequestParam String email){
        return new ResponseEntity<>(this.voterService.getVoterByEmail(email), HttpStatus.OK);
    }


}
