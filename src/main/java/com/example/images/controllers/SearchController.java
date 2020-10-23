package com.example.images.controllers;

import com.example.images.entity.Picture;
import com.example.images.repository.ImagesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController()
@RequestMapping("/search")
public class SearchController {

    private final ImagesRepository imagesRepository;

    public SearchController(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    @GetMapping(path = "{searchTerm}")
    public List<Picture> getImages(@PathVariable(name = "searchTerm") String searchTerm) {
        return imagesRepository.findByAnyCriteria(searchTerm);
    }
}
