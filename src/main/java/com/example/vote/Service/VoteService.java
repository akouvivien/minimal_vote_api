package com.example.vote.Service;

import com.example.vote.Dto.CandidatDto;
import com.example.vote.Dto.VoteDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Model.Vote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VoteService {

    Vote createVote(VoteDto votedto);

    Vote updateVote(Long id, VoteDto votedto);

    void deleteVoteId(Long id);

    Optional<Vote> getVoteId(Long id);

    List<Vote> getVotes();

    void deleteVotes();

    float numbersOfVoteByCandidat(Candidat candidat);

    float percentByCandidat(Candidat candidat);
}