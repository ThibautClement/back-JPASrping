package com.example.rng_springjpa.services;

import com.example.rng_springjpa.models.Game;
import com.example.rng_springjpa.models.League;
import com.example.rng_springjpa.models.User;
import com.example.rng_springjpa.repositories.GameRepository;
import com.example.rng_springjpa.repositories.LeagueRepository;
import com.example.rng_springjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(int id) {
        Optional<User> userToDelete = userRepository.findById(id);
        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

//    public void update(int id, League league) {
//        Optional<League> leagueToUpdate = leagueRepository.findById(id);
//        League updatingLeague;
//        if (leagueToUpdate.isPresent()) {
//            updatingLeague = leagueToUpdate.get();
//            updatingLeague.setId(id);
//            updatingLeague.setName(league.getName());
//            updatingLeague.setLogo(league.getLogo());
//            updatingLeague.setGame(league.getGame());
//        } else {
//            throw new RuntimeException();
//        }
//        leagueRepository.save(updatingLeague);
//    }


}
