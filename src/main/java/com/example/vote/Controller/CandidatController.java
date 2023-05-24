package com.example.vote.Controller;

import com.example.vote.Dto.CandidatDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/candidat")

public class CandidatController {

    @Autowired
    CandidatService candidatService;

    @GetMapping("")
    public ResponseEntity<List<Candidat>> getALLCandidats (){

        candidatService.getCandidats();

        return new ResponseEntity<>(candidatService.getCandidats(), HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Candidat> getCandidatById(@PathVariable("id") Long id) {

        candidatService.getCandidatId(id);

        return new ResponseEntity<>(candidatService.getCandidatId(id).get(), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<String> createCandidat(@Validated @RequestBody CandidatDto candidatdto) {

        candidatService.createCandidat(candidatdto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<Candidat> updateCandidat(@PathVariable("id") long id, @RequestBody CandidatDto candidatdto) {

        Candidat newUpdateCandidat = candidatService.updateCandidat(id, candidatdto);

        return new ResponseEntity<>(newUpdateCandidat, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<HttpStatus> deleteCandidat(@Validated @RequestBody  @PathVariable("id") long id) {

        candidatService.deleteCandidatId(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("")

    public ResponseEntity<HttpStatus> deleteAllPatients() {

        candidatService.deleteCandidats();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}