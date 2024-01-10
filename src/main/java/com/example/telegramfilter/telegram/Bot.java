package com.example.telegramfilter.core;

import com.example.telegramfilter.TelegramFilterApplication;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.util.List;

public class Bot extends TelegramLongPollingBot {

    private String BOT_TOKEN;
    private String BOT_NAME;

    public Bot() {
        Properties properties = new Properties();
        try (InputStream input = Bot.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BOT_TOKEN = properties.getProperty("bot.token");
        BOT_NAME = properties.getProperty("bot.name");
    }
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText())
        {
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