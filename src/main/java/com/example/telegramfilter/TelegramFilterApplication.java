package com.example.telegramfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TelegramFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramFilterApplication.class, args);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot(Bot.botName,Bot.BOT_TOKEN));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}