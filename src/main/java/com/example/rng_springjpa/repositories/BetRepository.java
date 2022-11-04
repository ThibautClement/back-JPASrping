package com.example.rng_springjpa.repositories;

import com.example.rng_springjpa.models.Bet;
import com.example.rng_springjpa.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends CrudRepository<Bet, Integer> {
}
