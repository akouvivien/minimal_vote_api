package com.example.vote.ServiceImpl;

import com.example.vote.Dto.VoteDto;
import com.example.vote.Model.*;
import com.example.vote.Repository.CandidatRepository;
import com.example.vote.Repository.VotantRepository;
import com.example.vote.Repository.VoteRepository;
import com.example.vote.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VoteServiceImpl  implements VoteService {
    @Autowired
    VoteRepository voteRepo;

    @Autowired
    VotantRepository votantRepo;

    @Autowired
    CandidatRepository candidatRepo;


    @Override
    public Vote createVote(VoteDto votedto) {

        Votant votant = votantRepo.findById(votedto.getVotant()).orElse(null);
        if(votant == null) throw new ApplicationContextException("le votant n'existe pas ");

        Candidat candidat = candidatRepo.findById(votedto.getCandidat()).orElse(null);
        if(candidat == null) throw new ApplicationContextException("le candidat n'existe pas ");

        // verification des votes
        Boolean verification =  voteRepo.existsByVotantAndCandidat(votant, candidat);
       if (verification) throw new ApplicationContextException("Ce vote a deja eu lieu");

        Vote newvote = new Vote();

        newvote.setVotant(votant);

        newvote.setCandidat(candidat);

        voteRepo.save(newvote);

        return newvote;
    }

    @Override
    public Vote updateVote(Long id, VoteDto votedto) {
        return null;
    }

    @Override
    public void deleteVoteId(Long id) {

    }

    @Override
    public Optional<Vote> getVoteId(Long id) {
        Optional<Vote> voteid = voteRepo.findById(id);
        return voteid;
    }

    @Override
    public List<Vote> getVotes() {
        return voteRepo.findAll();
    }

    @Override
    public void deleteVotes() {
        voteRepo.deleteAll();
    }

    @Override
    public float numbersOfVoteByCandidat(Candidat candidat) {
        return voteRepo.countVoteByCandidat(candidat);
    }

    @Override
    public float percentByCandidat(Candidat candidat) {
        float value = voteRepo.countVoteByCandidat(candidat);
        return  (value / votantRepo.count())* 100;

    }
}
