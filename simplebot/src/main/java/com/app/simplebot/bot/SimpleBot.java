package com.app.simplebot.bot;

import com.app.simplebot.model.JokeModel;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimpleBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return System.getenv("ENV_BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("ENV_BOT_KEY");
    }

    @Override
    public void onUpdateReceived(Update update) {

        String message = update.getMessage().getText();
        String user = update.getMessage().getFrom().getFirstName();
        SendMessage sendMessage = new SendMessage();

        System.out.println(user + ": " + message);

        // COMMANDS
        if (message.contains("/bot")) {
            sendMessage.setText(
                    "Unknown command. Please use </bot help> to see a list of commands"
            );

            // COMMAND LIST
            if (message.contains("help")) {
                sendMessage.setText(
                        "***Here are the list of simple bot commands (Prefixed: /bot): ***" + System.lineSeparator()
                        + System.lineSeparator()
                        + "hello" + System.lineSeparator()
                        + "what day is it?" + System.lineSeparator()
                        + "tell me a joke" + System.lineSeparator()
                        + "give me a quote" + System.lineSeparator()
                );
            }

            // GENERIC COMMANDS

            if (message.contains("hello")) {
                sendMessage.setText(
                        "Hello world " + user + "~!"
                );
            }

            if (message.contains("what day is it")) {
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedDate = localDate.format(formatter);
                System.out.println(formattedDate);
                sendMessage.setText(
                        "It is currently " + formattedDate
                );
            }

            // API COMMANDS
            if (message.contains("a joke") || message.contains("jokes")) {
                String uri = "http://localhost:8080/api/jokes";
                RestTemplate restTemplate = new RestTemplate();
                String joke = restTemplate.getForObject(uri, String.class);
                sendMessage.setText(joke);
            }

            if (message.contains("a quote")) {
                String uri = "http://localhost:8080/api/quotes";
                RestTemplate restTemplate = new RestTemplate();
                String quote = restTemplate.getForObject(uri, String.class);
                sendMessage.setText(quote);
            }
        }

        // RESPONSE
        if (sendMessage.getText() != null) {
            sendMessage.setChatId(update.getMessage().getChatId());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
