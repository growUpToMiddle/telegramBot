package com.example.telegramfilter.models;

import java.util.Objects;

public class Response {
    private String message;
    private boolean isEnabled;

    public Response(String message, boolean isEnabled) {

        this.message = message;
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return isEnabled == response.isEnabled && Objects.equals(message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, isEnabled);
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
