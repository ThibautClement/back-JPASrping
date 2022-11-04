package com.example.rng_springjpa.controllers;

import com.example.rng_springjpa.models.Bet;
import com.example.rng_springjpa.models.User;
import com.example.rng_springjpa.services.BetService;
import com.example.rng_springjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("bets")
public class BetController {

    BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Bet> getAllBets() {
        return this.betService.getAllBets();
    }

    @GetMapping("{id}")
    public Bet getById(@PathVariable int id) {
        Optional<Bet> bet = this.betService.findById(id);
//        if(game.isEmpty()) {
//            throw new RuntimeException();
//        }
        return bet.get();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void save(@RequestBody Bet bet) {
        this.betService.save(bet);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        this.betService.deleteById(id);
    }

//    @PutMapping("{id}")
//    @ResponseStatus(code= HttpStatus.OK)
//    public void update(@PathVariable int id, @RequestBody Game game) {
//        this.userService.update(id, game);
//    }
}
