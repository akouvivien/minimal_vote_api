package com.example.vote.Controller;

import com.example.vote.Dto.VoteDto;
import com.example.vote.Model.Candidat;
import com.example.vote.Model.Vote;
import com.example.vote.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    VoteService voteService;

    @GetMapping("")
    public ResponseEntity<List<Vote>> getALLVotes(){

        List<Vote> list = voteService.getVotes() ;

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}")

    public ResponseEntity<Vote> getVotesById(@PathVariable("id") Long id) {

        Optional<Vote> voteId =  voteService.getVoteId(id);

        return new ResponseEntity<>(voteId.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Vote> createVotes(@Validated @RequestBody VoteDto votedto) {

        voteService.createVote(votedto);

        return new ResponseEntity<>(voteService.createVote(votedto),HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    //modification via l'id
//    public ResponseEntity<Appointements> updateAppointements(@PathVariable("id") Long id, @RequestBody AppointementDto appointementdto) {
//
//        Appointements newUpdateAppointements = appoService.updateAppointement(id, appointementdto);
//
//        return new ResponseEntity<>(newUpdateAppointements, HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//
//    public ResponseEntity<String> deleteAppointements(@Validated @RequestBody  @PathVariable("id") Long id) {
//
//        appoService.DeleteAppointementId(id);
//
//        return new ResponseEntity<>("Suppression effectuer  avec succes !",HttpStatus.NO_CONTENT);
//    }

    @DeleteMapping("")

    public ResponseEntity<String> deleteAllVotes() {

        voteService.deleteVotes();

        return new ResponseEntity<>("L'ensemble des votes a éte effacer avec succes !",HttpStatus.NO_CONTENT);

    }
    //retourne le nombre de vote pour chaque candidat
    @PostMapping("/numbersofvote")
    public ResponseEntity<Float> voteNumbersByCandidat(@RequestBody Candidat candidat) {

        return new ResponseEntity<>(voteService.numbersOfVoteByCandidat(candidat),HttpStatus.OK);

    }
    //retourne le pourcentage de vote pour chaque candidat
    @PostMapping("/percentofvote")
    public ResponseEntity<Float> percentByCandidat(@RequestBody Candidat candidat) {

        return new ResponseEntity<>(voteService.percentByCandidat(candidat),HttpStatus.OK);

    }


}