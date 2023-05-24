package com.example.vote.ServiceImpl;

import com.example.vote.Dto.VotantDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Model.Votant;
import com.example.vote.Repository.VotantRepository;
import com.example.vote.Service.CandidatService;
import com.example.vote.Service.VotantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotantSeviceImpl implements VotantService {

    @Autowired
    VotantRepository votantRepo;
    @Override
    public Votant createVotant(VotantDto votantdto) {
        Votant newvotant = new Votant();

        newvotant.setFirstName(votantdto.getFirstName());

        newvotant.setLastName(votantdto.getLastName());

        newvotant.setEmail(votantdto.getEmail());

        newvotant.setLogin(votantdto.getLogin());

        newvotant.setPassword(votantdto.getPassword());

        votantRepo.save(newvotant);

        return newvotant;
    }

    @Override
    public Votant updateVotant(Long id, VotantDto votantdto) {
        Votant votantToUpdate = votantRepo.findById(id).orElse(null);

        if(votantToUpdate !=null){

            BeanUtils.copyProperties(votantdto, votantToUpdate, "id");

            votantRepo.save(votantToUpdate);
        }
        return votantRepo.save(votantToUpdate);
    }

    @Override
    public void deleteVotantId(Long id) {
        votantRepo.deleteById(id);

    }

    @Override
    public Optional<Votant> getVotantId(Long id) {
        Optional<Votant> votantid = votantRepo.findById(id);
        return votantid;
    }

    @Override
    public List<Votant> getVotants() {
        return votantRepo.findAll();
    }

    @Override
    public void deleteVotants() {
        votantRepo.deleteAll();

    }
}
