package com.example.rng_springjpa.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "result")
    private String result;

    @Column(name = "ptsT1")
    private int ptsT1;

    @Column(name = "ptsT2")
    private int ptsT2;

    @ManyToMany
    @JoinTable(
            name = "bet_user",
            joinColumns = @JoinColumn(name = "bet_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;
}
