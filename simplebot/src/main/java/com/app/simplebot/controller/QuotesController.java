package com.app.simplebot.controller;

import com.app.simplebot.model.QuoteModel;
import com.app.simplebot.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class QuotesController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quotes")
    public String getRandomMotivationalQuote() throws Exception {
        return quoteService.getRandomMotivationalQuote();
    }
}
