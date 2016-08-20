package io.developerinator.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

/**
 * Created by jvillanueva on 8/20/16.
 */
@Configuration
public class ObjectMapperConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void initJackson() {
        objectMapper.configure(FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(WRITE_DATES_AS_TIMESTAMPS, false);
    }
}
