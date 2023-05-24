package com.example.vote.Service;


import com.example.vote.Dto.VotantDto;
import com.example.vote.Model.Votant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VotantService {

    Votant createVotant(VotantDto votantdto);

    Votant updateVotant(Long id, VotantDto votantdto);

    void deleteVotantId(Long id);

    Optional<Votant> getVotantId(Long id);


    List<Votant> getVotants();

    void deleteVotants();
}