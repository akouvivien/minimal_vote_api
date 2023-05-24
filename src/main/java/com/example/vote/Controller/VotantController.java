package com.example.vote.Controller;

import com.example.vote.Dto.VotantDto;
import com.example.vote.Model.Votant;
import com.example.vote.Service.VotantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/votant")

public class VotantController {

    @Autowired
    VotantService votantService;

    @GetMapping("")
    public ResponseEntity<List<Votant>> getALLVotants (){

        votantService.getVotants();

        return new ResponseEntity<>(votantService.getVotants(), HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Votant> getVotantById(@PathVariable("id") Long id) {

        votantService.getVotantId(id);

        return new ResponseEntity<>(votantService.getVotantId(id).get(), HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<String> createVotant(@Validated @RequestBody VotantDto votantdto) {

        votantService.createVotant(votantdto);

        return new ResponseEntity<>("Enregistrement effectué avec succès !",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    //modification via l'id
    public ResponseEntity<Votant> updateVotant(@PathVariable("id") long id, @RequestBody VotantDto votantdto) {

        Votant newUpdateVotant = votantService.updateVotant(id, votantdto);

        return new ResponseEntity<>(newUpdateVotant, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteVotantId(@Validated @RequestBody  @PathVariable("id") long id) {

        votantService.deleteVotantId(id);

        return new ResponseEntity<>("La suppression a été effectué avec succès !",HttpStatus.OK);

    }

    @DeleteMapping("")

    public ResponseEntity<String> deleteAllVotants() {

        votantService.deleteVotants();

        return new ResponseEntity<>("Les votes ont été supprimés avec succès !",HttpStatus.OK);
    }

}
