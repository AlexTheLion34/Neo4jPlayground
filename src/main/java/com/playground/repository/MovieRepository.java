package com.playground.repository;

import com.playground.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jItemRepository<Movie> {
}
