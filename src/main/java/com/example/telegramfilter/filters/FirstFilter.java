package com.example.telegramfilter.filters;

import com.example.telegramfilter.models.Request;
import com.example.telegramfilter.models.Response;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FirstFilter extends MessageFilter {
    private final List<String> banWords = List.of("hello", "java", "world");

    @Override
    public Response doFilter(Request request) {
        for (String banword : banWords) {
            if (request.getMessage().toLowerCase().contains(banword)) {
                return createResponse();
            }
        }
            return null;
        }


    private Response createResponse() {
        return new Response( "We found banWord", true);
    }
}
