package com.example.rng_springjpa.services;

import com.example.rng_springjpa.models.Game;
import com.example.rng_springjpa.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Iterable<Game> getAllGame() {
        return gameRepository.findAll();
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public void deleteById(int id) {
        Optional<Game> gameToDelete = gameRepository.findById(id);
        if (gameToDelete.isPresent()) {
            gameRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public Optional<Game> findById(int id) {
        return gameRepository.findById(id);
    }

    public void update(int id, Game game) {
        Optional<Game> gameToUpdate = gameRepository.findById(id);
        Game updatingGame;
        if (gameToUpdate.isPresent()) {
            updatingGame = gameToUpdate.get();
            updatingGame.setId(id);
            updatingGame.setName(game.getName());
            updatingGame.setLogo(game.getLogo());
        } else {
            throw new RuntimeException();
        }
        gameRepository.save(updatingGame);
    }

}
