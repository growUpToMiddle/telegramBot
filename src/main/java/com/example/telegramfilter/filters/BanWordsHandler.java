package com.example.telegramfilter.filters;

import com.example.telegramfilter.service.BotHandler;

import java.util.List;

public class BanWordsHandler implements BotHandler {
    private BotHandler nextHandler;

    @Override
    public void setNextHandler(BotHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public String handleRequest(String message, List<String> banwords) {
        String response = new String();
        for (String banword : banwords) {
            if (message.toLowerCase().contains(banword)) {
                response = "Мы тут таких как \"" + banword.toUpperCase() + "\" не любим";
            } else if (nextHandler != null) {
                nextHandler.setNextHandler(null);//--
                nextHandler.handleRequest(message, banwords);
            }
        }
        return response;
    }

    @Override
    public BotHandler getNextHandler() {
        return nextHandler;
    }
}
