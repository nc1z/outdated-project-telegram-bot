package com.app.simplebot.service;

import com.app.simplebot.model.JokeModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    public String getRandomJoke() throws Exception{
        String uri = "https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate = new RestTemplate();
        JokeModel joke = restTemplate.getForObject(uri, JokeModel.class);
        if (joke == null) {
            throw new Exception("No joke found");
        }

        return joke.getSetup() + "\\n" + joke.getPunchline();
    }
}
