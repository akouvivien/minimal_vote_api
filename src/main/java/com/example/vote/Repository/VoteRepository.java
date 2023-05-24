package com.example.vote.Repository;

import com.example.vote.Dto.CandidatDto;
import com.example.vote.Dto.VotantDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Model.Votant;
import com.example.vote.Model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    //compte le nombre d'occurence d'un vote
    float countVoteByCandidat(Candidat candidat);

    //return true si la relation votant et candidat existe simultanement
    Boolean existsByVotantAndCandidat(Votant votant, Candidat candidat);

}
