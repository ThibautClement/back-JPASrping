package com.example.rng_springjpa.services;

import com.example.rng_springjpa.models.Bet;
import com.example.rng_springjpa.models.User;
import com.example.rng_springjpa.repositories.BetRepository;
import com.example.rng_springjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BetService {

    private BetRepository betRepository;

    @Autowired
    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public Iterable<Bet> getAllBets() {
        return betRepository.findAll();
    }

    public Optional<Bet> findById(int id) {
        return betRepository.findById(id);
    }

    public void save(Bet bet) {
        betRepository.save(bet);
    }

    public void deleteById(int id) {
        Optional<Bet> betToDelete = betRepository.findById(id);
        if (betToDelete.isPresent()) {
            betRepository.deleteById(id);
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
