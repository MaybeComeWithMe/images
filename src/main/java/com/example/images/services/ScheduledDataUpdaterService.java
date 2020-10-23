package com.example.images.services;

import com.example.images.entity.Picture;
import com.example.images.models.ImagesResponseModel;
import com.example.images.repository.ImagesRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ScheduledDataUpdaterService {

    private static Logger log = Logger.getLogger(ScheduledDataUpdaterService.class.getName());

    private final RestTemplate restTemplate;
    private final TokenService tokenService;
    private final ImagesRepository imagesRepository;

    ScheduledDataUpdaterService(RestTemplate restTemplate, TokenService tokenService, ImagesRepository imagesRepository) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
        this.imagesRepository = imagesRepository;
    }

    @Scheduled(fixedRateString = "${period}")
    public void getImages() {
        log.info("Getting images from API");
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(String.valueOf(tokenService.getTokenResponseSuggestionModel().getToken()));

        List<String> ids = restTemplate
                .exchange("/images", HttpMethod.GET, new HttpEntity(headers), ImagesResponseModel.class)
                .getBody()
                .getPictures()
                .stream()
                .map(Picture::getId)
                .collect(Collectors.toList());

        List<Picture> pictures = new ArrayList<>();

        for (String id : ids) {
            Picture picture = restTemplate
                    .exchange("/images/" + id, HttpMethod.GET, new HttpEntity(headers), Picture.class)
                    .getBody();
            pictures.add(picture);
        }

        imagesRepository.saveAll(pictures);
    }
}

