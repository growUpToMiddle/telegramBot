package com.example.telegramfilter.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot {
    private final List<String> banwords = new ArrayList<>();


    private String BOT_TOKEN;
    private String BOT_NAME;

    public Bot() {

        banwords.add("horse");
        banwords.add("frog");
        banwords.add("fox");
        banwords.add("cat");
        banwords.add("dog");
        banwords.add("pootin");

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

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMess = update.getMessage(); // смотрим что написано в сообщении пользователя

                    String chatId = inMess.getChatId().toString();
                    String response = parseMessage(inMess.getText());
                    SendMessage outMess = new SendMessage();
                    outMess.setChatId(chatId);
                    outMess.setText(response);
                    try {
                        if (!response.isBlank()){
                            execute(outMess);
                        }
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
            }
    }

    public String parseMessage(String textMsg) {
        String response = new String();

        for (String banword:banwords) {
            if (textMsg.toLowerCase().contains(banword)) {
                response = "Мы тут не любим -" + banwords + " поаккуратней со словами";

            }
        }
        return response;
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