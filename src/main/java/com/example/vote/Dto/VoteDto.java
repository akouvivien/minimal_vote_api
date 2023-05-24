package com.example.vote.Dto;

import com.example.vote.Model.Candidat;
import com.example.vote.Model.Votant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteDto {

    private Long votant;
    private Long candidat;
}
