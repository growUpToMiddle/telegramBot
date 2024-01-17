package com.example.telegramfilter.models;

import com.example.telegramfilter.filters.BanWordsHandler;
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

    public static String response;
    protected final List<String> banwords = new ArrayList<>();

    protected static final String BOT_TOKEN;
    protected static String botName;
    private HandlerChain handlerChain = new HandlerChain();

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

        banwords.add("horse");
        banwords.add("frog");
        banwords.add("fox");
        banwords.add("cat");
        banwords.add("dog");
        banwords.add("pootin");
    }


    @Override
    public String getBotUsername() {
        return botName;
    }


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message inMess = update.getMessage();

            String chatId = inMess.getChatId().toString();// get id
            response = parseMessage(inMess.getText()); // work with 1rs filter (received String)
            SendMessage outMess = new SendMessage();
            outMess.setChatId(chatId);
            outMess.setText(response);
            try {
                if (!response.isBlank()) {
                    execute(outMess); // - отсылает в чат
                }
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String parseMessage(String textMsg) {
        BanWordsHandler banWordsHandler = new BanWordsHandler();
        handlerChain.addHandler(banWordsHandler);
           return handlerChain.handleRequest(textMsg,banwords);
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