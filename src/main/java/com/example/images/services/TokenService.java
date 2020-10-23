package com.example.images.services;

import com.example.images.entity.Picture;
import com.example.images.models.ImagesResponseModel;
import com.example.images.models.TokenResponseSuggestionModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.lang.System.exit;

@Service
public class TokenService {

    private static Logger log = Logger.getLogger(TokenService.class.getName());

    private final RestTemplate restTemplate;
    private TokenResponseSuggestionModel tokenResponseSuggestionModel;

    @Value("${key.value}")
    private String apiKey;

    public TokenResponseSuggestionModel getTokenResponseSuggestionModel() {
        return tokenResponseSuggestionModel;
    }

    public TokenService(RestTemplate restTemplate, TokenResponseSuggestionModel tokenResponseSuggestionModel) {
        this.restTemplate = restTemplate;
        this.tokenResponseSuggestionModel = tokenResponseSuggestionModel;
    }

    @Scheduled(fixedRateString = "${key.live}")
    public void updateToken() {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);

        tokenResponseSuggestionModel = restTemplate.postForObject("/auth", map, tokenResponseSuggestionModel.getClass());
        if (tokenResponseSuggestionModel.isAuth()) {
            log.info("New API Token - " + tokenResponseSuggestionModel.getToken());
        } else {
            log.warning("You got a wrong API key, please check application.properties file");
            exit(0);
        }
    }


    @PostConstruct
    private void init() {
        Map<String, String> map = new HashMap<>();
        map.put("apiKey", apiKey);

        tokenResponseSuggestionModel = restTemplate.postForObject("/auth", map, tokenResponseSuggestionModel.getClass());

        if (tokenResponseSuggestionModel.isAuth()) {
            log.info("API Token - " + tokenResponseSuggestionModel.getToken());
        } else {
            log.warning("You got a wrong API key, please check application.properties file");
            exit(0);
        }
    }

}
