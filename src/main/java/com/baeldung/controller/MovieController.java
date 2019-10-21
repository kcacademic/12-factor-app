package com.baeldung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.domain.Movie;
import com.baeldung.service.MovieService;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> retrieveAllMovies() {
        return movieService.retrieveAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie retrieveMovies(@PathVariable Long id) {
        return movieService.retrieveMovies(id);
    }

    @PostMapping("/movies")
    public Long createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
}