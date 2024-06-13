package org.constituencyservice.service;

import org.constituencyservice.dto.ConstituencyDto;
import org.constituencyservice.dto.VoterDetailsDto;

import java.util.List;

public interface ConstituencyService {
    Long totalVotersByConstituency(Integer constituencyId);
    List<VoterDetailsDto> getVotersByConstituency(Integer constituencyId);
    ConstituencyDto addConstituency(ConstituencyDto constituencyDto);
}
