package com.example.telegramfilter;

import com.example.telegramfilter.botStuf.Bot;
import com.example.telegramfilter.config.FilterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@EnableConfigurationProperties(FilterConfig.class)
public class TelegramFilterApplication {

    private final Bot bot;

    public static void main(String[] args) {
        SpringApplication.run(TelegramFilterApplication.class, args);

    }

    public TelegramFilterApplication (Bot bot){
        this.bot = bot;
    }
}

/*
 1.возможно стоит добавить разделение на команды и обычную запись сообщения для изменения списка банслов
(вставить условие - что если сообщение начинается на "/" - сделать то или иное действие (remove / add))

2.не забыть решить проблему с пропертями про передачу имени и токена бота
(варианты с сайтов и чата не работают ,при вытаскивании через полный путь выдаёт ошибку vds)

3. ???
*/