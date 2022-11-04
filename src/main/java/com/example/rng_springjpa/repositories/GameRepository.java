package com.example.rng_springjpa.repositories;

import com.example.rng_springjpa.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

}
