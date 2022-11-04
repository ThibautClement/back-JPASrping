package com.example.rng_springjpa.repositories;

import com.example.rng_springjpa.models.League;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CrudRepository<League, Integer> {
}
