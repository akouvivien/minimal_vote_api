package com.example.vote.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidatDto {

    private String firstName;
    private String lastName;

    private String email;
    private String login;
    private String password;

}
