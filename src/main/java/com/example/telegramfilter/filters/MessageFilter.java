package com.example.telegramfilter.filters;

import com.example.telegramfilter.models.Request;
import com.example.telegramfilter.models.Response;

public abstract class MessageFilter {
    private MessageFilter nextFilter;
    public void setNextFilter(MessageFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public MessageFilter getNextFilter() {
        return nextFilter;
    }

    public Response doNextFilter(Request request) {
        Response result = doFilter(request);
        if (result != null && result.isEnabled()) {
            return result;
        }
        if (checkNextFilter()) {
            return new Response("it's over",true);
        }
        return getNextFilter().doNextFilter(request);
    }
    private boolean checkNextFilter() {
        return nextFilter == null;
    }
    public abstract Response doFilter(Request request);
}
