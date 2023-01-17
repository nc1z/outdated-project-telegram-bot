package com.app.simplebot.service;

import com.app.simplebot.model.QuoteModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class QuoteService {

    public String getRandomMotivationalQuote() throws Exception {
        String uri = "https://zenquotes.io/api/quotes/";
        RestTemplate restTemplate = new RestTemplate();
        QuoteModel[] quotes = restTemplate.getForObject(uri, QuoteModel[].class);
        if (quotes.length < 1) {
            throw new Exception("No quotes found");
        }
        String quote = Arrays.stream(quotes).findFirst().get().getQ();
        String author = Arrays.stream(quotes).findFirst().get().getA();

        return "\"" + quote + "\"" + " - " + author;
    }
}
