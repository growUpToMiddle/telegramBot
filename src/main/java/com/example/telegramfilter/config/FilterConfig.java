package com.example.telegramfilter.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "filters")
public class FilterConfig {

    private final List<String> listOfChains;

    public FilterConfig(List<String> listOfChains) {
        this.listOfChains = listOfChains;
    }

    public List<String> getListOfChains() {
        return listOfChains;
    }
}
