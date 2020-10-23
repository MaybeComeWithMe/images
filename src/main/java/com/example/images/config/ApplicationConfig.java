package com.example.images.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class ApplicationConfig {

    @Value("${url}")
    private String url;

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler(url);

        return restTemplateBuilder
                .uriTemplateHandler(uriTemplateHandler)
                .build();
    }

}
