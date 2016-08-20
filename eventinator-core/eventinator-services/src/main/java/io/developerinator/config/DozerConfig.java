package io.developerinator.config;

import io.developerinator.app.domain.*;
import io.developerinator.app.dto.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by jvillanueva on 5/1/16.
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper mapper() {
        return new DozerBeanMapper();
    }

    @PostConstruct
    public void dozerMapping() {
        mapper().addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Account.class, AccountDto.class);
                mapping(DateRange.class, DateRangeDto.class);
                mapping(Event.class, EventDto.class);
                mapping(Interest.class, InterestDto.class);
                mapping(Location.class, LocationDto.class);
                mapping(Profile.class, ProfileDto.class);
                mapping(TimeRange.class, TimeRangeDto.class);
                mapping(WatchOut.class, WatchOutDto.class);
            }
        });
    }
}
