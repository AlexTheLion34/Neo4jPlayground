package com.playground.repository;

import com.playground.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends Neo4jItemRepository<Actor> {
    Optional<Actor> findByName(String name);
}
