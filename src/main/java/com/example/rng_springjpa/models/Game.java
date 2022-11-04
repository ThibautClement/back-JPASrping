package com.example.rng_springjpa.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "logo")
    private String logo;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "game")
    private List<League> leagueList;
}
