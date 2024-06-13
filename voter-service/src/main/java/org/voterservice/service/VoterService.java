package org.voterservice.service;

import org.voterservice.dtos.VoterDto;

import java.util.List;

public interface VoterService {
    VoterDto addVoter(VoterDto voterDto);
    List<VoterDto> getAllVoters();
    VoterDto getVoterById(Integer id);
    Long totalNoOfVoters();
    Long totalVotersByGender(String gender);
    VoterDto getVoterByEmail(String email);
}
