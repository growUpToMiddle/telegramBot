package com.example.telegramfilter.models;

import com.example.telegramfilter.service.BotHandler;

import java.util.List;

public class HandlerChain {
    private BotHandler firstHandler;

    public void addHandler(BotHandler handler) {
        if (firstHandler == null) {
            firstHandler = handler;
        } else {
            BotHandler currentHandler = firstHandler;
            while (currentHandler.getNextHandler() != null) {
                currentHandler = currentHandler.getNextHandler();
            }
            currentHandler.setNextHandler(handler);
        }
    }

    public String handleRequest(String message, List<String> banwords) {
        String anser = new String();
        if (firstHandler != null) {
            anser= firstHandler.handleRequest(message,banwords);
        } else {
            System.out.println("Нет обработчиков для запроса: " + message);
        }
        return anser;
    }
}