package com.example.rng_springjpa.repositories;

import com.example.rng_springjpa.models.League;
import com.example.rng_springjpa.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
