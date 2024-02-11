package com.example.telegramfilter.service;

import com.example.telegramfilter.models.Request;
import com.example.telegramfilter.models.Response;

public interface FilterService {
    Response getResponse(Request request);
}
