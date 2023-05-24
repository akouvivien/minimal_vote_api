package com.example.vote.Service;

import com.example.vote.Dto.CandidatDto;
import com.example.vote.Model.Candidat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CandidatService {

    Candidat createCandidat(CandidatDto candidatdto);

    Candidat updateCandidat(Long id, CandidatDto candidatdto);

    void deleteCandidatId(Long id);

    Optional<Candidat> getCandidatId(Long id);


    List<Candidat> getCandidats();

    void deleteCandidats();
}
