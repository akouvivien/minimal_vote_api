package com.example.vote.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "votes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //un vote correspont a un votant
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "votant_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Votant votant;

    //plusieurs votes peuvent concerner un seul candidat
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = " candidat_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Candidat candidat;

    @Column(name = "create_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date createAt;

    @Column(name = "update_at",columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updateAt;


}
