package com.example.telegramfilter.service;

import java.util.List;

public interface BotHandler {
    void setNextHandler(BotHandler nextHandler);
    String handleRequest(String message, List<String> banwords);

    BotHandler getNextHandler();
}