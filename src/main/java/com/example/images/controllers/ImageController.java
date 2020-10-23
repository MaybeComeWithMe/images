package com.example.images.controllers;

import com.example.images.entity.Picture;
import com.example.images.repository.ImagesRepository;
import com.example.images.services.TokenService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/images")
public class ImageController {

    private final RestTemplate restTemplate;
    private final TokenService tokenService;
    private final ImagesRepository imagesRepository;

    ImageController(RestTemplate restTemplate, TokenService tokenService, ImagesRepository imagesRepository) {
        this.restTemplate = restTemplate;
        this.tokenService = tokenService;
        this.imagesRepository = imagesRepository;
    }

    @GetMapping
    public Map<String, String> getImages(@RequestParam(required = false, name = "page") String page, @RequestParam(required = false, name = "limit") String limit) {
        Map<String, String> result;
        if ((page != null && !page.isEmpty()) && (limit != null && !limit.isEmpty())) {
            result = imagesRepository
                    .findAll(PageRequest.of(Integer.parseInt(page), Integer.parseInt(limit)))
                    .getContent()
                    .stream()
                    .collect(Collectors.toMap(Picture::getId, Picture::getCropped_picture));
        } else {
            result = imagesRepository
                    .findAll()
                    .stream()
                    .collect(Collectors.toMap(Picture::getId, Picture::getCropped_picture));
        }
        return result;
    }

    @GetMapping(path = "{id}")
    public Picture getImages(@PathVariable(name = "id") String id) {
        return imagesRepository.findById(id).orElse(new Picture());
    }
}
