package com.example.rng_springjpa.controllers;

import com.example.rng_springjpa.models.Game;
import com.example.rng_springjpa.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("games")
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<Game> getAllGames() {
        return this.gameService.getAllGame();
    }

    @GetMapping("{id}")
    public Game getById(@PathVariable int id) {
        Optional<Game> game = this.gameService.findById(id);
//        if(game.isEmpty()) {
//            throw new RuntimeException();
//        }
        return game.get();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void save(@RequestBody Game game) {
        this.gameService.save(game);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        this.gameService.deleteById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public void update(@PathVariable int id, @RequestBody Game game) {
        this.gameService.update(id, game);
    }
}
