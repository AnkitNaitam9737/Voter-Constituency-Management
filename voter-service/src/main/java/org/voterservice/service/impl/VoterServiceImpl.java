package org.voterservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.voterservice.dtos.VoterDto;
import org.voterservice.entity.Voter;
import org.voterservice.repository.VoterRepository;
import org.voterservice.service.VoterService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VoterRepository voterRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public VoterDto addVoter(VoterDto voterDto) {
        Voter voter = this.mapper.map(voterDto, Voter.class);
        voter.setPassword(encoder.encode(voter.getPassword()));
        Voter savedVoter = this.voterRepository.save(voter);
        return this.mapper.map(savedVoter, VoterDto.class);
    }

    @Override
    public List<VoterDto> getAllVoters() {
        List<Voter> voters = this.voterRepository.findAll();
        return voters.stream().map(voter -> this.mapper.map(voter,VoterDto.class)).collect(Collectors.toList());
    }

    @Override
    public VoterDto getVoterById(Integer id) {
        return this.mapper.map(this.voterRepository.findById(id), VoterDto.class);
    }

    @Override
    public Long totalNoOfVoters() {
        return this.voterRepository.count();
    }

    @Override
    public Long totalVotersByGender(String gender) {
        return this.voterRepository.findAll().stream().filter(voter -> voter.getGender().equals(gender)).count();
    }

    @Override
    public VoterDto getVoterByEmail(String email) {
        return this.mapper.map(this.voterRepository.findByEmail(email),VoterDto.class);
    }
}
