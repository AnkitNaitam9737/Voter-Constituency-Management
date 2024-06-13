package org.voterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.voterservice.dtos.VoterDto;
import org.voterservice.entity.Voter;

import java.util.Optional;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {

    Optional<Voter> findByEmail(String email);
}
