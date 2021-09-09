package com.playground.controller;

import com.playground.model.Movie;
import com.playground.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController extends Neo4jItemController<Movie> {

    @Autowired
    public MovieController(MovieService service) {
        super(service);
    }
}
