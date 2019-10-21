package com.baeldung;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.controller.MovieController;
import com.baeldung.domain.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieApplicationE2eTests {
    @Autowired
    private MovieController movieController;
    @LocalServerPort
    private int port;

    @Test
    public void givenMovieApplicationWhenQueriedWithAnIdThenGetExpectedMovie() throws Exception {
        Movie movie = new Movie();
        movie.setId(100L);
        movie.setTitle("Hello World!");
        movieController.createMovie(movie);
        when().get(String.format("http://localhost:%s/movies/100", port))
            .then()
            .statusCode(is(200))
            .body(containsString("Hello World!".toLowerCase()));
    }
}