package com.example.telegramfilter;

import com.example.telegramfilter.models.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class TelegramFilterApplication {



    public static void main(String[] args) {
        SpringApplication.run(TelegramFilterApplication.class, args);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot("@Omnisiabot","6720727438:AAFmtwmS6tc23xJeUVQ-yp9zsauGLw0EFl0"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}