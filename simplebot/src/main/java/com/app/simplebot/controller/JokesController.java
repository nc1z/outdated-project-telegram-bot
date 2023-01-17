package com.app.simplebot.controller;

import com.app.simplebot.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JokesController {

    @Autowired
    private JokeService jokeService;

    @GetMapping("/jokes")
    public String getRandomJoke() throws Exception {
        return jokeService.getRandomJoke();
    }
}
