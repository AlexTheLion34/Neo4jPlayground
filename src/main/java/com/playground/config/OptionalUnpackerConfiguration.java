package com.playground.config;

import com.playground.extension.OptionalUnpackHelper;
import com.playground.model.Movie;
import com.playground.model.Actor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OptionalUnpackerConfiguration {

    @Bean
    public OptionalUnpackHelper<Movie> movieUnpacker() {
        return new OptionalUnpackHelper<>();
    }

    @Bean
    public OptionalUnpackHelper<Actor> actorUnpacker() {
        return new OptionalUnpackHelper<>();
    }
}
