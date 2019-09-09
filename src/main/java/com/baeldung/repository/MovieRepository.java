package com.baeldung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baeldung.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
