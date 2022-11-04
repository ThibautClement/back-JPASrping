package com.example.rng_springjpa.services;

import com.example.rng_springjpa.models.Game;
import com.example.rng_springjpa.models.League;
import com.example.rng_springjpa.repositories.GameRepository;
import com.example.rng_springjpa.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private LeagueRepository leagueRepository;
    private GameRepository gameRepository;

    @Autowired
    public LeagueService(LeagueRepository leagueRepository, GameRepository gameRepository) {
        this.leagueRepository = leagueRepository;
        this.gameRepository = gameRepository;
    }

    public Iterable<League> getAllLeague() {
        return leagueRepository.findAll();
    }

    public Optional<League> findById(int id) {
        return leagueRepository.findById(id);
    }

    public void save(int game_id, League league) {
        Game game = this.gameRepository.findById(game_id).get();
        league.setGame(game);
        leagueRepository.save(league);
    }

    public void deleteById(int id) {
        Optional<League> leagueToDelete = leagueRepository.findById(id);
        if (leagueToDelete.isPresent()) {
            leagueRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public void update(int id, League league) {
        Optional<League> leagueToUpdate = leagueRepository.findById(id);
        League updatingLeague;
        if (leagueToUpdate.isPresent()) {
            updatingLeague = leagueToUpdate.get();
            updatingLeague.setId(id);
            updatingLeague.setName(league.getName());
            updatingLeague.setLogo(league.getLogo());
            updatingLeague.setGame(league.getGame());
        } else {
            throw new RuntimeException();
        }
        leagueRepository.save(updatingLeague);
    }


}
