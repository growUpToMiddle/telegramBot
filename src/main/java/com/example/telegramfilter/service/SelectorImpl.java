package com.example.telegramfilter.service;

import com.example.telegramfilter.config.FilterConfig;
import com.example.telegramfilter.filters.MessageFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SelectorImpl implements Selector{
    private final FilterConfig filterConfig;
    private final Map<String, MessageFilter> filters;

    public SelectorImpl(FilterConfig filterConfig, Map<String, MessageFilter> filters) {
        this.filterConfig = filterConfig;
        this.filters = filters;
    }

    @Override
    public List<MessageFilter> getFilters() {
        return new ArrayList<>(filters.values());
    }

    @Override
    public MessageFilter getFilter(String filterName) {
        return this.filters.get(filterName);
    }

    @Override
    public MessageFilter getFilterChain() {
        List<MessageFilter> filters = getFilters();
        Collections.reverse(filters);
        for (int i = 0; i < filters.size() - 1; i++) {
            filters.get(i).setNextFilter(filters.get(i + 1));
        }
        return filters.get(0);
    }
}
