package com.example.telegramfilter.botStuf;

import com.example.telegramfilter.models.Request;
import com.example.telegramfilter.models.Response;
import com.example.telegramfilter.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

@Component
public class Bot extends TelegramLongPollingBot {

    public static String response;
    protected final List<String> banwords = new ArrayList<>();

    protected static String BOT_TOKEN ;
    protected static String botName ;

   private final FilterService filterService;

    @Autowired
    public Bot(FilterService filterService) {
        this.filterService = filterService;
        initializeBanWords();
    }

    private void initializeBanWords() {
        banwords.add("horse");
        banwords.add("frog");
        banwords.add("fox");
        banwords.add("cat");
        banwords.add("dog");
        banwords.add("pootin");
    }

    public void setBotToken(String botToken) {
        BOT_TOKEN = botToken;
    }

    public void setBotName(String botName) {
        Bot.botName = botName;
    }

    public String getBotToken(){
        return BOT_TOKEN;
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
            response = String.valueOf(parseMessage(inMess.getText()).getMessage()); // work with 1rs filter (received String)
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

    public Response parseMessage(String textMsg) {

        Request request = new Request(textMsg);
        return filterService.getResponse(request);
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