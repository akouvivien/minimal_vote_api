package com.example.vote.Repository;

import com.example.vote.Model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CandidatRepository extends JpaRepository<Candidat,Long> {
}
