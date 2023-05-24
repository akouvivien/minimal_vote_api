package com.example.vote.ServiceImpl;

import com.example.vote.Dto.CandidatDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Repository.CandidatRepository;
import com.example.vote.Service.CandidatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatServiceImpl  implements CandidatService {

    @Autowired
    CandidatRepository candidatRepo;
    @Override
    public Candidat createCandidat(CandidatDto candidatdto) {

        Candidat newcandidat = new Candidat();

        newcandidat.setFirstName(candidatdto.getFirstName());

        newcandidat.setLastName(candidatdto.getLastName());

        newcandidat.setEmail(candidatdto.getEmail());

        newcandidat.setLogin(candidatdto.getLogin());

        newcandidat.setPassword(candidatdto.getPassword());

        candidatRepo.save(newcandidat);

        return newcandidat;
    }

    @Override
    public Candidat updateCandidat(Long id, CandidatDto candidatdto) {
        Candidat candidatToUpdate = candidatRepo.findById(id).orElse(null);

        if(candidatToUpdate !=null){

            BeanUtils.copyProperties(candidatdto, candidatToUpdate, "id");

            candidatRepo.save(candidatToUpdate);
        }
        return candidatRepo.save(candidatToUpdate);
    }

    @Override
    public void deleteCandidatId(Long id) {
        candidatRepo.deleteById(id);
    }

    @Override
    public Optional<Candidat> getCandidatId(Long id) {
        Optional<Candidat> candidatid = candidatRepo.findById(id);
        return candidatid;
    }

    @Override
    public List<Candidat> getCandidats() {
        return candidatRepo.findAll();
    }

    @Override
    public void deleteCandidats() {
        candidatRepo.deleteAll();
    }
}
