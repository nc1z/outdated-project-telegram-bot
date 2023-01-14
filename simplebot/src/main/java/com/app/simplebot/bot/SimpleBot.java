package com.app.simplebot.bot;

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
                    "How may I help you, " + user + "?"
            );

            if (message.contains("hello")) {
                sendMessage.setText(
                        "Hello world " + user + "~!"
                );
            }

            if (message.contains("what time is it?")) {
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedDate = localDate.format(formatter);
                System.out.println(formattedDate);
                sendMessage.setText(
                        "It is currently " + formattedDate
                );
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
