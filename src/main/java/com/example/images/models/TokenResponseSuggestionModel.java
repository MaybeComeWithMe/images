package com.example.images.models;

import org.springframework.stereotype.Component;

@Component
public class TokenResponseSuggestionModel {
    private boolean auth;
    private String token;

    public TokenResponseSuggestionModel() {
    }

    public TokenResponseSuggestionModel(boolean auth, String token) {
        this.auth = auth;
        this.token = token;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
