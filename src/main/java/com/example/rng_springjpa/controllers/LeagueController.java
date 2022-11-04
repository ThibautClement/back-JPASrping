package com.example.rng_springjpa.controllers;

import com.example.rng_springjpa.models.League;
import com.example.rng_springjpa.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("gamess")
public class LeagueController {

    LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<League> getAllGames() {
        return this.leagueService.getAllLeague();
    }

//    @GetMapping("{game_id}/leagues/{league_id}")
//    public League getById(@PathVariable int game_id, @PathVariable int league_id) {
//        Optional<League> league = this.leagueService.findById(league_id);
////        if(league.isEmpty()) {
////            throw new RuntimeException();
////        }
//        return league.get();
//    }

    @PostMapping("{game_id}/leagues")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void save(@PathVariable int game_id, @RequestBody League league) {
        this.leagueService.save(game_id, league);
    }

//
//    @DeleteMapping("{id}")
//    @ResponseStatus(code= HttpStatus.NO_CONTENT)
//    public void deleteById(@PathVariable int id) {
//        this.leagueService.deleteById(id);
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(code= HttpStatus.OK)
//    public void update(@PathVariable int id, @RequestBody League league) {
//        this.leagueService.update(id, league);
//    }

}
