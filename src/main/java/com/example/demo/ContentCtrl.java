package com.example.demo;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentCtrl {

    private static final Logger LOG = LoggerFactory.getLogger(ContentCtrl.class);

    @GetMapping(path = "/api/content", produces = APPLICATION_JSON_UTF8_VALUE)
    public Content content(Optional<Integer> size) {
        Integer count = size.orElse(1024);
        LOG.info("Requesting content with size '{}'...", count);
        return new Content(randomAlphabetic(count));
    }
}
