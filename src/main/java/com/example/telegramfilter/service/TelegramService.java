package com.example.telegramfilter.service;

import com.example.telegramfilter.botStuf.Bot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class TelegramService {
    private final Bot bot;

    public TelegramService(Bot bot) {
        this.bot = bot;
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            bot.setBotName("@Omnisiabot");
            bot.setBotToken("6720727438:AAFmtwmS6tc23xJeUVQ-yp9zsauGLw0EFl0");
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
