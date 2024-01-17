package com.example.telegramfilter;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
<<<<<<< HEAD
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Bot extends TelegramLongPollingBot {

    private final List<String> banwords = new ArrayList<>();

=======

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot {

>>>>>>> 30466b1f784af54791ce802f5f5d1138cc491fac
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
<<<<<<< HEAD

        banwords.add("horse");
        banwords.add("frog");
        banwords.add("fox");
        banwords.add("cat");
        banwords.add("dog");
        banwords.add("pootin");
    }


=======
    }

>>>>>>> 30466b1f784af54791ce802f5f5d1138cc491fac
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
<<<<<<< HEAD
            Message inMess = update.getMessage();

            String chatId = inMess.getChatId().toString();
            String response = parseMessage(inMess.getText());
            SendMessage outMess = new SendMessage();
            outMess.setChatId(chatId);
            outMess.setText(response);
            try {
                if (!response.isBlank()) {
                    execute(outMess);
                }
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String parseMessage(String textMsg) {
        String response = new String();

        for (String banword : banwords) {
            if (textMsg.toLowerCase().contains(banword)) {
                response = "Мы тут таких как \"" + banword.toUpperCase() + "\" не любим";

            }
        }
        return response;
    }


=======
            Message inMess = update.getMessage(); // смотрим что написано в сообщении пользователя
            String chatId = inMess.getChatId().toString(); // достаём id чата
            SendMessage outMess = new SendMessage(); // создаём наш ответ пользователю
        }
    }

>>>>>>> 30466b1f784af54791ce802f5f5d1138cc491fac
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}