package com.example.telegramfilter.service;

import com.example.telegramfilter.filters.MessageFilter;

import java.util.List;

public interface Selector {
    List<MessageFilter> getFilters();
    MessageFilter getFilter(String filterName);
    MessageFilter getFilterChain();
}
