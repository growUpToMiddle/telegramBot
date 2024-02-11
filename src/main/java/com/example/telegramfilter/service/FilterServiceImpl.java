package com.example.telegramfilter.service;

import com.example.telegramfilter.models.Request;
import com.example.telegramfilter.models.Response;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService{
    private final Selector selector;

    public FilterServiceImpl(Selector selector) {
        this.selector = selector;
    }

    @Override
    public Response getResponse(Request request) {
        return selector.getFilterChain().doNextFilter(request);
    }
}
