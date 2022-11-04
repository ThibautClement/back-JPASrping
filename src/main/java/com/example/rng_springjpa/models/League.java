package com.example.rng_springjpa.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "leagues")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game game;
}
