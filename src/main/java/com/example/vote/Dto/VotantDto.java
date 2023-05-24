package com.example.vote.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VotantDto {

    private String firstName;
    private String lastName;

    private String email;
    private String login;
    private String password;

}
