package com.example.rng_springjpa.controllers;

import com.example.rng_springjpa.models.Game;
import com.example.rng_springjpa.models.User;
import com.example.rng_springjpa.services.GameService;
import com.example.rng_springjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Iterable<User> getAllGames() {
        return this.userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        Optional<User> user = this.userService.findById(id);
//        if(game.isEmpty()) {
//            throw new RuntimeException();
//        }
        return user.get();
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        this.userService.save(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        this.userService.deleteById(id);
    }

//    @PutMapping("{id}")
//    @ResponseStatus(code= HttpStatus.OK)
//    public void update(@PathVariable int id, @RequestBody Game game) {
//        this.userService.update(id, game);
//    }
}
