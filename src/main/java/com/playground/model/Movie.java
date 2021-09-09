package com.playground.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@Setter
public class Movie extends Neo4jItem {

    public Movie(String title, Integer released) {
        this.title = title;
        this.released = released;
    }

    private String title;

    private Integer released;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private Set<Actor> actors = new HashSet<>();
}
