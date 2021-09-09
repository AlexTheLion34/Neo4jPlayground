package com.playground.repository;

import com.playground.model.Neo4jItem;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jItemRepository<T extends Neo4jItem> extends Neo4jRepository<T, Long> {
}
