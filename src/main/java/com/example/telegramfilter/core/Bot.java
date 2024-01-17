package com.example.telegramfilter.core;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.List;

public class Bot extends TelegramLongPollingBot {

    final private String BOT_TOKEN = "6720727438:AAFmtwmS6tc23xJeUVQ-yp9zsauGLw0EFl0";
    final private String BOT_NAME = "@Omnisiabot";
    ReplyKeyboardMarkup replyKeyboardMarkup;


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
            System.out.println(inMess.getText()); // проверочка что сообщение считывается
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
