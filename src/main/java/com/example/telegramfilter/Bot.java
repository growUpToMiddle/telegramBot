package com.example.telegramfilter;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot {

    protected static final String BOT_TOKEN;
    protected static String botName;

    static {
        Properties properties = new Properties();
        try (InputStream input = Bot.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BOT_TOKEN = properties.getProperty("bot.token");
        botName = properties.getProperty("bot.name");
    }

    public Bot(String BOT_NAME, String BOT_TOKEN) {
        super(BOT_TOKEN);
        botName = BOT_NAME;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMess = update.getMessage(); // смотрим что написано в сообщении пользователя
            String chatId = inMess.getChatId().toString(); // достаём id чата
            SendMessage outMess = new SendMessage(); // создаём наш ответ пользователю
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}