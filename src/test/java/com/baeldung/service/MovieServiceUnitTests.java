package com.baeldung.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.baeldung.domain.Movie;
import com.baeldung.repository.MovieRepository;

public class MovieServiceUnitTests {
    @InjectMocks
    private MovieService movieService;
    @Mock
    private MovieRepository movieRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenMovieServiceWhenQueriedWithAnIdThenGetExpectedMovie() throws Exception {

        Movie movie = new Movie();
        movie.setTitle("Hello World!");
        Mockito.when(movieRepository.findById(100L))
            .thenReturn(Optional.ofNullable(movie));
        Movie result = movieService.retrieveMovies(100L);
        Assert.assertEquals(movie.getTitle()
            .toLowerCase(), result.getTitle());

    }
}
