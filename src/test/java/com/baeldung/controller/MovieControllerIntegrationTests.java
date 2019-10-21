package com.baeldung.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.domain.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieControllerIntegrationTests {
    @Autowired
    private MovieController movieController;

    @Test
    public void givenMovieControllerWhenQueriedWithAnIdThenGetExpectedMovie() throws Exception {
        Movie movie = new Movie();
        movie.setId(100L);
        movie.setTitle("Hello World!");
        movieController.createMovie(movie);

        Movie result = movieController.retrieveMovies(100L);
        Assert.assertEquals(movie.getTitle()
            .toLowerCase(), result.getTitle());

    }
}
