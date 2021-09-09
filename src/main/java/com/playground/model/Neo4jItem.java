package com.playground.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@Getter
@Setter
public abstract class Neo4jItem {

    @Id
    @GeneratedValue
    private Long id;
}
