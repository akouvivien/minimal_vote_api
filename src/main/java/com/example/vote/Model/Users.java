package com.example.vote.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "veillez entrer le firstName")
    private String firstName;
    @NotNull(message = "veillez entrer le lastName")
    private String lastName;

    @NotNull(message = "l'email ne peut etre vide")
    @Column(unique=true)
    private String email;
    @NotNull(message = "le login ne peut etre vide")
    @Column(unique=true)
    private String login;
    @NotNull(message = "le password ne peut etre vide")
    private String password;



}
