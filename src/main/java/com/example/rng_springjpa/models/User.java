package com.example.rng_springjpa.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pot")
    private int pot;

    @ManyToMany(mappedBy = "users")
    private Set<Bet> bets;
}
