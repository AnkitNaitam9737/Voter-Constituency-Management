package org.constituencyservice.service.impl;

import org.constituencyservice.dto.ConstituencyDto;
import org.constituencyservice.dto.VoterDetailsDto;
import org.constituencyservice.entity.Constituency;
import org.constituencyservice.repository.ConstituencyRepository;
import org.constituencyservice.service.ConstituencyService;
import org.constituencyservice.utils.VoterFeign;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstituencyServiceImpl implements ConstituencyService {

    @Autowired
    private VoterFeign client;

    @Autowired
    private ConstituencyRepository constituencyRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Long totalVotersByConstituency(Integer constituencyId) {
        List<VoterDetailsDto> dtoList = this.client.getAllVoters().getBody();
        Long countVoters = dtoList.stream().filter((voter) -> voter.getConstituencyId() == constituencyId).count();
        return countVoters;
    }

    @Override
    public List<VoterDetailsDto> getVotersByConstituency(Integer constituencyId) {
        List<VoterDetailsDto> dtoList = this.client.getAllVoters().getBody();
        List<VoterDetailsDto> voterDetailsDtoList = dtoList.stream().filter((voter) -> voter.getConstituencyId() == constituencyId).collect(Collectors.toList());
        return voterDetailsDtoList;
    }

    @Override
    public ConstituencyDto addConstituency(ConstituencyDto constituencyDto) {
        Constituency constituency = this.constituencyRepository.save(this.mapper.map(constituencyDto, Constituency.class));
        return this.mapper.map(constituency, ConstituencyDto.class);
    }
}
