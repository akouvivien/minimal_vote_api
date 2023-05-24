package com.example.vote.Repository;

import com.example.vote.Model.Votant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotantRepository extends JpaRepository<Votant,Long> {

}
